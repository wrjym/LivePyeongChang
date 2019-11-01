package com.livepyeongchang.a12three.livepyeongchang.Model;

/**
 * Created by kwakgee on 2017. 9. 21..
 */

public class Model_Pic {

    private String url;
    private String name;

    public Model_Pic(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}
