package com.design.factory.serviceImpl;

import com.design.factory.service.OperatingSystem;

public class WindowOperating extends OperatingSystem {

    public WindowOperating(String version, String architecture) {
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
