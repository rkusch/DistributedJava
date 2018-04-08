/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week10.namesapp10.data.dao;

import edu.wctc.dj.week10.namesapp10.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ryan
 */
public interface INameDAO extends JpaRepository<Name,String> {
    
}
