/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.data;

import edu.wctc.dj.week9.model.Address;
import edu.wctc.dj.week9.model.Name;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ryan
 */
public class AddressDAO {
    public Address getAddress(Name name) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("Select * From Address Where nameid = ?");
            stmt.setString(1, name.getId());
            rs = stmt.executeQuery();
            Address address = null;
            if (rs.next()) {
                String id = rs.getString("id");
                String nameid = rs.getString("nameid");
                String street = rs.getString("street");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zip = rs.getString("zip");
                address = new Address(street,city,state,zip);
                
         
            }
            return address;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
        
    }

