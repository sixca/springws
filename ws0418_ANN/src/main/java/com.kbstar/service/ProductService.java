package com.kbstar.service;

import com.kbstar.dao.ProductDAO;
import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;
import com.kbstar.frame.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("pservice")
public class ProductService implements MyService<Integer, ProductDTO> {
    @Autowired
    ProductDAO dao;

    public void register(ProductDTO productDTO) {
        dao.insert(productDTO);
        System.out.println("register. send mail!");
    }

    public void remove(Integer i) {
        dao.delete(i);
        System.out.println("delete. send mail!");
    }

    public void modify(ProductDTO productDTO) {
        dao.update(productDTO);
        System.out.println("update. send mail!");
    }

    public ProductDTO get(Integer i) {
        return dao.select(i);
    }

    public List<ProductDTO> get() {
        return dao.select();
    }
}
