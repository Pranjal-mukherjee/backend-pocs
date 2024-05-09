package com.design.factory.serviceImpl;

import com.design.factory.service.OperatingSystem;

public class MacOperating extends OperatingSystem {
    public MacOperating(String version, String architecture) {
        super(version, architecture);
    }

    @Override
    public void changeDir(String dir) {
        System.out.println(dir);
    }

    @Override
    public void removeDir(String dir) {
        System.out.println(dir);
    }
}
