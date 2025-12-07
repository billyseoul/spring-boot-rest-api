package com.cloudvendor.rest_demo.service.impl;

import com.cloudvendor.rest_demo.exception.CloudVendorNotFoundException;
import com.cloudvendor.rest_demo.model.CloudVendor;
import com.cloudvendor.rest_demo.repository.CloudVendorRepository;
import com.cloudvendor.rest_demo.service.CloudVendorService;
import org.springframework.stereotype.Service;
import java.util.List;

// Business logic

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

  CloudVendorRepository cloudVendorRepository;

  public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
    this.cloudVendorRepository = cloudVendorRepository;
  }

  @Override
  public String createCloudVendor(CloudVendor cloudVendor) {
    cloudVendorRepository.save(cloudVendor);
    return "Success";
  }

  @Override
  public String updateCloudVendor(CloudVendor cloudVendor) {
    cloudVendorRepository.save(cloudVendor);
    return "Success";
  }

  @Override
  public String deleteCloudVendor(String cloudVendorId) {
    cloudVendorRepository.deleteById(cloudVendorId);
    return "Success";
  }

  @Override
  public CloudVendor getCloudVendor(String cloudVendorId) {
    if (cloudVendorRepository.findById(cloudVendorId).isEmpty())
      throw new CloudVendorNotFoundException("Requested Cloud Vendor not found");
    return cloudVendorRepository.findById(cloudVendorId).get();
  }

  @Override
  public List<CloudVendor> getAllCloudVendors() {
    return cloudVendorRepository.findAll();
  }
}
