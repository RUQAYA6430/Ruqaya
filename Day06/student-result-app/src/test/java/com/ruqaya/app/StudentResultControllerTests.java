package com.ruqaya.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({StudentResultController.class})
@ActiveProfiles(value = "test")
public class StudentResultControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Value("${studentResult.get.url}")
    String geturl;

    @Value("${studentResult.get.all.url}")
    String getallurl;

    @Value("${studentResult.post.url}")
    String posturl;

    @Value("${studentResult.put.url}")
    String puturl;

    @Value("${studentResult.delete.url}")
    String deleteurl;

    @Test
    public void testStudentResultGet() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(geturl).param("name","stud1"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("", result);
    }

    @Test
    public void testStudentResultWithValueGet() throws Exception {
        StudentResult studentResult=new StudentResult("stud1", "rol01", "SCL1", 89, 76, 75, 90, 99);
        mockMvc.perform(post(posturl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(studentResult)).accept(MediaType.APPLICATION_JSON));

        ResultActions responseEntity  = mockMvc.perform(get(geturl).param("name","stud1"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertNotNull(result);
    }

    @Test
    public void testAllStudentResultGet() throws Exception {
        ResultActions responseEntity  = mockMvc.perform(get(getallurl));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertNotNull(result);
    }

    @Test
    public void testSaveStudentResultPost() throws Exception {
        StudentResult student=new StudentResult("name1", "rol01", "SCL1", 89, 76, 75, 90, 99);
        ResultActions responseEntity  = mockMvc.perform(post(posturl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(student)).accept(MediaType.APPLICATION_JSON));
        responseEntity.andExpect(status().isOk());

    }

    @Test
    public void testUpdateStudentResultPut() throws Exception {
        StudentResult studentResult=new StudentResult("name1", "rol01", "SCL1", 89, 76, 75, 90, 99);
        mockMvc.perform(post(posturl).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(studentResult)).accept(MediaType.APPLICATION_JSON));

        ResultActions responseEntity  = mockMvc.perform(put(puturl).param("name","name1")
                .param("schoolName","SCL2"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertNotNull(result);

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}