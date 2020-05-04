package com.model;

public class User {
	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private String addressline;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private byte profileImage;
	private String status;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User( String firstName, String middleName, String lastName, String email, String password, String addressline,
			String street, String city, String state, String zipcode, byte profileImage, String status) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.addressline = addressline;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.profileImage = profileImage;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressline() {
		return addressline;
	}

	public void setAddressline(String addressline) {
		this.addressline = addressline;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public byte getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(byte profileImage) {
		this.profileImage = profileImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ",firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", addressline=" + addressline + ", street=" + street + ", city="
				+ city + ", state=" + state + ", zipcode=" + zipcode + ", profileImage=" + profileImage + ", status="
				+ status + "]";
	}

}
