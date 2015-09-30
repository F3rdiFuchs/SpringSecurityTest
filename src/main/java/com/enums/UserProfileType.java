package com.enums;

public enum UserProfileType {
	USER("USER"),
    GUEST("ADMIN"),
    ADMIN("GUEST");
     
    private String userProfileType;
     
    private UserProfileType(String userProfileType) {
        this.userProfileType = userProfileType;
    }
     
    public String getUserProfileType() {
        return userProfileType;
    }
}
