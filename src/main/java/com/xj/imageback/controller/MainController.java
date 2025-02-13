package com.xj.imageback.controller;

import com.xj.imageback.common.BaseResponse;
import com.xj.imageback.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {
    // 健康检查
    @GetMapping(value = "/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }
}
