package com.dao;

import com.entity.Items;
import com.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品的业务逻辑类
 * Created by xkc on 8/21/15.
 */
public class ItemsDao {

    //获得所有的商品信息
    public List<Items> getAllItems() {

        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Items> list = new ArrayList<>();//商品集合

        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items;";//sql语句
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setCity(resultSet.getString("city"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                item.setPicture(resultSet.getString("picture"));

                list.add(item);//将商品加入商品集合
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {//关闭对象，由小到大关闭，数据集->statement
            //此处不能关闭连接对象，因为Connection对象是单例模式，关闭后影响后面的方法使用
            if (resultSet != null) {//释放数据集对象
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {//释放语句对象
                try {
                    statement.close();
                    statement = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }


    //根据商品编号获得商品资料
    public Items getItemById(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items where id=?;";//sql语句
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Items item = new Items();
                item.setId(resultSet.getInt("id"));
                item.setCity(resultSet.getString("city"));
                item.setName(resultSet.getString("name"));
                item.setPrice(resultSet.getInt("price"));
                item.setPicture(resultSet.getString("picture"));

                return item;
            } else {
                return null;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {//关闭对象，由小到大关闭，数据集->statement
            //此处不能关闭连接对象，因为Connection对象是单例模式，关闭后影响后面的方法使用
            if (resultSet != null) {//释放数据集对象
                try {
                    resultSet.close();
                    resultSet = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {//释放语句对象
                try {
                    statement.close();
                    statement = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    //获取最近浏览的前5条商品信息
    public List<Items> getViewList(String list) {
        List<Items> itemsList = new ArrayList<>();
        int iCount = 5;//每次返回前5条记录
        if (list != null && list.length() > 0) {
            String[] arr = list.split(",");

            if (arr.length >= 5) {//如果大于5条
                for (int i = arr.length - 1; i >= arr.length - iCount; i -- ) {
                    int id = Integer.parseInt(arr[i]);
                    itemsList.add(getItemById(id));
                }

            }else {//否则倒序全部输出
                for(int i = arr.length - 1; i >= 0; i --){
                    int id = Integer.parseInt(arr[i]);
                    itemsList.add(getItemById(id));
                }
            }
            return itemsList;

        } else {
            return null;
        }


    }


}
