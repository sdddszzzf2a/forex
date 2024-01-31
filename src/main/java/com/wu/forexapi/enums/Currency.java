package com.wu.forexapi.enums;

public enum Currency {

	USD("usd");
	
	private final String displayName;
	
    Currency(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
