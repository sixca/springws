package com.kbstar.dao;

import com.kbstar.dto.ProductDTO;
import com.kbstar.frame.MyDao;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements MyDao<Integer, ProductDTO> {

    public void insert(ProductDTO productDTO) {
        System.out.println("Inserted Product: "+ productDTO);
    }

    public void delete(Integer i) {
        System.out.println("Deleted Product: "+ i);
    }

    public void update(ProductDTO productDTO) {
        System.out.println("updated Product: "+ productDTO);
    }

    public ProductDTO select(Integer i) {
        ProductDTO product = null;
        product = new ProductDTO(i, "청바지", 35000, 5);
        return product;
    }

    public List<ProductDTO> select() {
        List<ProductDTO> list = null ;
        list = new ArrayList();
        list.add(new ProductDTO(2, "면바지", 30000, 8 ));
        list.add(new ProductDTO(3, "와이셔츠", 25000, 30 ));
        list.add(new ProductDTO(4, "난닝구", 10000, 50 ));
        return list;
    }
}
