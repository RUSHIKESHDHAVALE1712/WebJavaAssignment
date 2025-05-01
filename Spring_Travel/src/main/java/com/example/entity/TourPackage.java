package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TourPackage {

	@Id
	 @Column(name = "pid")
	 private int packageId; 
	 @Column(name = "pname" ,length = 50)
	 private String packageName;
	 @Column(name = "pduration" ,length = 50)
	 private String duration;
	 @Column(name = "price" ,length = 50)
	 private Double price;
	 @Column(name = "trans_type" ,length = 50)
	 private String transportationType;
	 
	 public TourPackage() {
		
	}

	public TourPackage(int packageId, String packageName, String duration, Double price, String transportationType) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.duration = duration;
		this.price = price;
		this.transportationType = transportationType;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTransportationType() {
		return transportationType;
	}

	public void setTransportationType(String transportationType) {
		this.transportationType = transportationType;
	}

	@Override
	public String toString() {
		return "Tour_Pakage [packageId=" + packageId + ", packageName=" + packageName + ", duration=" + duration
				+ ", price=" + price + ", transportationType=" + transportationType + "]";
	}
}
