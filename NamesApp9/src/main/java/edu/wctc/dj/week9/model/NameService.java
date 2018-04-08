/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.model;

import edu.wctc.dj.week9.data.AddressDAO;
import edu.wctc.dj.week9.data.NameDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ryan
 */
public class NameService {

   

    public Name getName(String id) {
   
        return null;
    }

    public List<Name> getAllNames() throws Exception {
        NameDAO nameDAO = new NameDAO();
        List<Name> nameList = nameDAO.getNames();
        
        if (nameList != null) {
            AddressDAO addressDAO = new AddressDAO();
            for (Name name: nameList) {
                name.setAddress(addressDAO.getAddress(name));
            }
        }
        return nameList;
    }

    public List<Name> findNames(String search) {

        return null;
    }

}
