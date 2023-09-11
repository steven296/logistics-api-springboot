package com.stevendev.apirest.mock.packages;

import com.stevendev.apirest.domain.packages.Package;

public class PackageMock {

    public static Package build() {
        var mypackage = new Package();
        mypackage.setCode("C2023");

        return mypackage;
    }
}
