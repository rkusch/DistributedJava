/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week10.namesapp10.services;

import edu.wctc.dj.week10.namesapp10.data.dao.INameDAO;
import edu.wctc.dj.week10.namesapp10.model.Name;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ryan
 */
@Service
@Transactional
public class NameService {
   
   @Autowired
   private INameDAO nameDAO;

    public Name getName(String id) {
   
        return nameDAO.findOne(id);
    }

    public List<Name> getAllNames() throws Exception {
        return nameDAO.findAll();
    }

    public List<Name> findNames(String search) {
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("last", startsWith().ignoreCase());
        Name name = new Name();
        name.setLast(search);
        return nameDAO.findAll(Example.of(name, matcher));
    }

}
