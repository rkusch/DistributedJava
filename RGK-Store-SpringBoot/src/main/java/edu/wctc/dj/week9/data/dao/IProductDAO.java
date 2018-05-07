/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.data.dao;
import edu.wctc.dj.week9.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Ryan
 */
public interface IProductDAO extends JpaRepository<Product,String> {
  

}
