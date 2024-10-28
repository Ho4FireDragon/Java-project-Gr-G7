package com.shopkoi.shopkoi.Service;

public enum StaffSchedule {
    DI_LAM("đi làm"),
    NGHI("nghỉ");

    private String displayName;

    StaffSchedule(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
