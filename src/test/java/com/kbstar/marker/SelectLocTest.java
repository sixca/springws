package com.kbstar.marker;

import com.kbstar.service.CartService;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SelectLocTest {

    @Autowired
    MarkerService service;

    @Test
    void contextLoads(){
        try {
            service.getLocMarker("S");
            service.getLocMarker("B");
            service.getLocMarker("J");
            log.info("SUCCESS------------------");
        } catch (Exception e) {
            log.info("에러 .....---------------- ");
           e.printStackTrace();
        }
    }
}
