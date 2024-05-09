package com.design.factory.service;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class OperatingSystem {

    private String version;
    private String architecture;

    public abstract void changeDir(String dir);

    public abstract void removeDir(String dir);

}
