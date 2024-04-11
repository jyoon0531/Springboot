package com.study.Pr03VMAns.dao;

import com.study.Pr03VMAns.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface IProductDao {
    List<Product> selectAll();

    int insert(Product product);

    Optional<Product> findById(int id);

    int update(Product product);

    int delete(int index);
}
