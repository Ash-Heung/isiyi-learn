package com.isiyi.impala;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;

/**
 * 类描述
 * <p></p>
 *
 * @version 1.0.0
 * @description: TestImpala
 * @author: 向鹏飞
 * @since: 2021/12/13
 */
public class TestImpala {

    private Connection connection;
    @Before
    public void before(){
        try {
            String driver = "org.apache.hive.jdbc.HiveDriver";
            String JDBCUrl = "jdbc:hive2://cdh05:21050/;auth=noSasl";
            String username = "";
            String password = "";
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(JDBCUrl, username, password);
        }catch (Exception e){
        }
    }


    @Test
    public void testMeta() throws Exception{

        DatabaseMetaData metaData = connection.getMetaData();

        ResultSet catalogsResultSet = metaData.getCatalogs();
        while (catalogsResultSet.next()) {
            String setString = catalogsResultSet.getString("table_cat");
            System.out.println(setString);

        }
        String[] types = { "TABLE" };
        ResultSet resultSet = metaData.getTables("ads", "", "", types);
        while (resultSet.next()) {
            String tableName = resultSet.getString(3);
            System.out.println("Table Name = " + tableName);

        }



    }


    @Test
    public void testSelect() throws Exception{
        String sql = "SELECT count(*) FROM ads.ads_pos_cash_order_item_r;";
        System.out.println("查询语句："+sql);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        int columnCount = rs.getMetaData().getColumnCount();
        while (rs.next()){
            for(int i=1;i<=columnCount;i++){
                System.out.print(rs.getString(i)+"\t");
            }
            System.out.println("");
        }


    }


    @After
    public void after(){
        if(null != connection){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


}
