package com.cloudvendor.rest_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cloud_vendor_info")
public class CloudVendor {

  @Id  // ← REQUIRED - marks the primary key
  private String vendorId;
  private String vendorName;
  private String vendorAddress;
  private String vendorPhoneNumber;

  // Empty constructor - REQUIRED for JPA
  public CloudVendor() {

  }

  // Full constructor
  public CloudVendor(String vendorId, String vendorName,
                     String vendorAddress, String vendorPhoneNumber) {
    this.vendorId = vendorId;
    this.vendorName = vendorName;
    this.vendorAddress = vendorAddress;
    this.vendorPhoneNumber = vendorPhoneNumber;

  }

  // All your getters and setters...
  public String getVendorId() {
    return vendorId;
  }

  public void setVendorId(String vendorId) {
    this.vendorId = vendorId;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getVendorAddress() {
    return vendorAddress;
  }

  public void setVendorAddress(String vendorAddress) {
    this.vendorAddress = vendorAddress;
  }

  public String getVendorPhoneNumber() {
    return vendorPhoneNumber;
  }

  public void setVendorPhoneNumber(String vendorPhoneNumber) {
    this.vendorPhoneNumber = vendorPhoneNumber;
  }
}