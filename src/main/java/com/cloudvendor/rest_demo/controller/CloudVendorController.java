package com.cloudvendor.rest_demo.controller;

import com.cloudvendor.rest_demo.model.CloudVendor;
import com.cloudvendor.rest_demo.response.ResponseHandler;
import com.cloudvendor.rest_demo.service.CloudVendorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

  CloudVendorService cloudVendorService;

  public CloudVendorController(CloudVendorService cloudVendorService) {
    this.cloudVendorService = cloudVendorService;
  }


  // Read specific Cloud Vendor details from DB
  @GetMapping("{vendorId}")
  public ResponseEntity<Object> getCloudVendorDetails(@PathVariable(value = "vendorId") String vendorId) {
    return ResponseHandler.responseBuilder("Requested Vendor Details are given here",
            HttpStatus.OK, cloudVendorService.getCloudVendor(vendorId));
  }

  // Read all Cloud Vendor details from DB
  @GetMapping()
  public List<CloudVendor> getAllCloudVendorDetails() {
    return cloudVendorService.getAllCloudVendors();
  }

  @PostMapping
  public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    cloudVendorService.createCloudVendor(cloudVendor);
    return "Cloud vendor created successfully";
  }

  @PutMapping
  public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
    cloudVendorService.updateCloudVendor(cloudVendor);
    return "Cloud vendor updated successfully";
  }
  @DeleteMapping("{vendorId}")
  public String deleteCloudVendorDetails(@PathVariable(value = "vendorId") String vendorId) {
    cloudVendorService.deleteCloudVendor(vendorId);
    return "Cloud vendor deleted successfully";
  }
}
