package com.orange_hrm.enums;

import lombok.Getter;

public enum Endpoints {
    ALERT("/alerts"),

    FRAMES("/frames"),

    TEXTBOX("/text-box"),

    WEBTABLES("/webtables"),
    BUTTONS("/buttons"),
    MENU("/menu"),
    PROGRESSBAR("/progress-bar"),
    SELECT_MENU("/select-menu"),
    CHECKBOX("/checkbox"),
    PRACTICE_FORM("/automation-practice-form"),
    BROWSERHELPER("/browser-windows");

    @Getter
    String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }
}
