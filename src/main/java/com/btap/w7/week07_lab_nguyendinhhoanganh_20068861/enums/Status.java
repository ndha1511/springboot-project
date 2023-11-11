package com.btap.w7.week07_lab_nguyendinhhoanganh_20068861.enums;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE(1),
    PAUSE(0),
    INACTIVE(-1);

    private final int status;

    Status(int status) {
        this.status = status;
    }

}
