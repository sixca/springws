package com.kbstar.cust;

import com.kbstar.dto.Adm;
import com.kbstar.dto.Cust;
import com.kbstar.service.AdmService;
import com.kbstar.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@Slf4j
@SpringBootTest
class UpdateTest {

	@Autowired
	CustService service;

	@Test
	void contextLoads() {
		Cust cust = new Cust("id01", "pwd01", "둘리");
		try {
			service.modify(cust);
		} catch (Exception e) {
			log.info("에러 ..... ");
			e.printStackTrace();
		}
	}
}
