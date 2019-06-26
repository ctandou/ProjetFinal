/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


public class DataSource {
    
    	public static javax.sql.DataSource getDataSource() {
		org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setDatabaseName("sample");
		ds.setUser("app");
		ds.setPassword("app");
		ds.setServerName("localhost");
		ds.setPortNumber(1527);
		return ds;
	}	
    
}