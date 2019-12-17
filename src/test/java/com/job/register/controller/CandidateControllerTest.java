package com.job.register.controller;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.job.register.dto.response.CandidateResponse;
import com.job.register.service.impl.CandidateServiceImpl;



@WebMvcTest()
@WebAppConfiguration
public class CandidateControllerTest {

   @Autowired
   MockMvc mockMvc;

  // @Autowired
   //CandidateServiceImpl candidateService;

   @Test
   public void addCandidateCall() throws Exception {
	   
	   String requestPayload = "{\n" +
				"  \"name\": \"Rahul\",\n" +
				"  \"qualification\": \"BE\",\n" +
				"  \"skills\": \"java\",\n" +
				"  \"experience\": \"4\",\n" +
				"  \"exam\": {\n" +

				"      \"position\": \"java developer\",\n" +
				"      \"date\": \"16-dec-2019\"\n" +
				"    }" ;
	   
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/candidate")
				.accept(MediaType.APPLICATION_JSON)
				.content(requestPayload)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = null;
		try {
			//result = mockMvc.perform(requestBuilder).andReturn();
			//System.out.println("JUnit addCandidateCall Response :: " + result.getResponse().getContentAsString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" addCandidate Call from CandidateControllerTest");


    // Mockito.when(candidateService.addCandidate(Mockito.any())).thenReturn(new CandidateResponse());
     //mockMvc.perform(MockMvcRequestBuilders.post("/api/candidate"));

   }
   
   
}