package org.example.build.controller;

import org.example.build.service.BuildService;

public class BuildController {
    private final BuildService buildService = new BuildService();
    public void build(){
        String path = buildService.save();
        System.out.println(path + " 파일의 내용이 갱신되었습니다.");
    }

    public void save() {
        String path = buildService.save();
        System.out.println(path + " 파일에 저장했습니다.");
    }

    public void road() {
        buildService.road();
    }
}
