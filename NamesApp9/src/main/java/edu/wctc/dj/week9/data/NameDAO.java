/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wctc.dj.week9.data;

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
public class NameDAO {
    public List<Name> getNames() throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = ConnectionUtil.getConnection();
            stmt = conn.prepareStatement("Select * From Name");
            rs = stmt.executeQuery();
            List<Name> nameList = new ArrayList<>();
            while (rs.next()) {
                String id = rs.getString("id");
                String firstName = rs.getString("firstname");
                String lastName = rs.getString("lastname");
                Name name = new Name(id,firstName,lastName, null);
                nameList.add(name);
            }
            return nameList;
            
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        }
    }
    
}
