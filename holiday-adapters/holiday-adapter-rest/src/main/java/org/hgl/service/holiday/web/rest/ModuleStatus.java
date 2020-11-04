package org.hgl.service.holiday.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class ModuleStatus {
    private static Logger log = LoggerFactory.getLogger(ModuleStatus.class);

    @GetMapping("/status")
    public String moduleStatus() {
        log.info("Requested status: OK");
        return "OK";
    }
}
