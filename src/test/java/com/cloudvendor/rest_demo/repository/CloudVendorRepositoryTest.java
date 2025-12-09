package com.cloudvendor.rest_demo.repository;
import com.cloudvendor.rest_demo.model.CloudVendor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
public class CloudVendorRepositoryTest {

  @Autowired
  private CloudVendorRepository cloudVendorRepository;
  CloudVendor cloudVendor;

  @BeforeEach
  void setUp() {
    cloudVendor = new CloudVendor("1", "AWS", "123 No Name Drive", "123456789");
    cloudVendorRepository.save(cloudVendor);
  }

  @AfterEach
  void tearDown() {
    cloudVendor = null;
    cloudVendorRepository.deleteAll();
  }

  // Test case Success

  @Test
  void  testFindByVendorName_Found() {
    List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("AWS");
    assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
    assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
  }

  // Test case Failure

  @Test
  void testFindByVendorName_NotFound() {
    List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("GCP");
    assertThat(cloudVendorList.isEmpty()).isTrue();
  }
}
