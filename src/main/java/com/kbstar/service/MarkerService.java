package com.kbstar.service;


import com.kbstar.dto.Cart;
import com.kbstar.dto.Marker;
import com.kbstar.frame.KBService;
import com.kbstar.mapper.MarkerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MarkerService implements KBService<Integer, Marker> {
    /**
     * 등록 및 가입 진행
     * argument : Object
     * return : null
     *
     * @param marker
     */

    @Autowired
    MarkerMapper mapper;

    @Override
    public void register(Marker marker) throws Exception {
        mapper.insert(marker);
    }

    @Override
    public void remove(Integer i) throws Exception {
        mapper.delete(i);
    }

    @Override
    public void modify(Marker marker) throws Exception {
        mapper.update(marker);
    }

    @Override
    public Marker get(Integer i) throws Exception {
        return mapper.select(i);
    }

    @Override
    public List<Marker> get() throws Exception {
        return mapper.selectall();
    }

    public List<Marker> getLocMarker(String loc) throws Exception{
        return mapper.getlocmarker(loc);
    }
    //기존에 없는 기능 추가. loc을 선택하면 ,, 해당 맛집들의 DB출력
}