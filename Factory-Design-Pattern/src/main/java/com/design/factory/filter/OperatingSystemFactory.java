package com.design.factory.filter;

import com.design.factory.service.OperatingSystem;
import com.design.factory.serviceImpl.MacOperating;
import com.design.factory.serviceImpl.WindowOperating;

public class OperatingSystemFactory {

    private OperatingSystemFactory() {
    }

    public static OperatingSystem getInstance(String type, String version, String architecture) {
        switch (type) {
            case "WINDOWS":
                return new WindowOperating(version, architecture);
            case "MAC":
                return new MacOperating(version, architecture);
            default:
                throw new IllegalArgumentException("OS Not supported");
        }
    }
}
