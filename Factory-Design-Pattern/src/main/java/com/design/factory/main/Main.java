package com.design.factory.main;

import com.design.factory.filter.OperatingSystemFactory;
import com.design.factory.service.OperatingSystem;
import com.design.factory.serviceImpl.WindowOperating;


public class Main {
    public static void main(String[] args) {

        OperatingSystem windowsOS = OperatingSystemFactory.getInstance("WINDOWS", "10", "x64");
        OperatingSystem macOS = OperatingSystemFactory.getInstance("MAC", "MAC 20.04", "x64");

        System.out.println("Windows OS Version: " + windowsOS.getVersion());
        System.out.println("Windows OS Architecture: " + windowsOS.getArchitecture());
        System.out.println("MAC OS Version: " + macOS.getVersion());
        System.out.println("MAC OS Architecture: " + macOS.getArchitecture());

        windowsOS.changeDir("C:\\example\\directory");
        macOS.removeDir("/home/user/example/directory");
    }
}
