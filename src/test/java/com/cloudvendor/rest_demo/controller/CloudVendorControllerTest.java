package com.cloudvendor.rest_demo.controller;

import com.cloudvendor.rest_demo.model.CloudVendor;
import com.cloudvendor.rest_demo.service.CloudVendorService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.ObjectWriter;
import tools.jackson.databind.SerializationFeature;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CloudVendorController.class)
class CloudVendorControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockitoBean
  private CloudVendorService cloudVendorService;
  CloudVendor cloudVendorOne;
  CloudVendor cloudVendorTwo;
  List<CloudVendor> cloudVendorList = new ArrayList<>();



  @BeforeEach
  void setUp() {
    cloudVendorOne = new CloudVendor("1", "AWS", "123 no address st", "123456789");
    cloudVendorTwo = new CloudVendor("2", "GCP", "456 no address st", "987654321");
    cloudVendorList.add(cloudVendorOne);
    cloudVendorList.add(cloudVendorTwo);
  }

  @AfterEach
  void tearDown() {
    cloudVendorList.clear();
  }

  @Test
  void testGetCloudVendorDetails() throws Exception {
    when(cloudVendorService.getCloudVendor("1")).thenReturn(cloudVendorOne);
    this.mockMvc.perform(get("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());

  }

  @Test
  void testGetAllCloudVendorDetails() throws Exception {
    when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
    this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
  }

  @Test
  void testCreateCloudVendorDetails() throws Exception {
    String requestJson = new ObjectMapper().writeValueAsString(cloudVendorOne);
    when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
    this.mockMvc.perform(post("/cloudvendor")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestJson))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testUpdateCloudVendorDetails() throws Exception {
    String requestJson = new ObjectMapper().writeValueAsString(cloudVendorOne);
    when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
    this.mockMvc.perform(put("/cloudvendor")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestJson))
            .andDo(print())
            .andExpect(status().isOk());
  }

  @Test
  void testDeleteCloudVendorDetails() throws Exception {
    when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Success");
    this.mockMvc.perform(delete("/cloudvendor/1")).andDo(print()).andExpect(status().isOk());
  }
}