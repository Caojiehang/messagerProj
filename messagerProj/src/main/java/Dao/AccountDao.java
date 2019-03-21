package Dao;

import bean.Account;

import java.sql.SQLException;
import java.util.List;

/**
* @Author: Jiehang CAO, Fiona Li
* @Description: this is interface for Account bean
* @Date: 17:32 2019-03-03
*/
public interface AccountDao {

    //add new account to database
    void add(Account account) throws SQLException;

    //update the data info
    public void update(Account account)throws SQLException;

    //delete data from database
    public void delete(int id)throws SQLException;

    //find account in database by id
    public Account findById(int id)throws SQLException;
    // find account in database by username
    public Account findByName(String username)throws SQLException;

    //find all account in database
    public List<Account> findAll()throws SQLException;

}
