package Dao;

import bean.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
/**
* @Author: Jiehang CAO
* @Description:this for database testing
* @Date: 19:14 2019-03-21
*/
@Slf4j
public class AccountDaoImplTest {

    AccountDaoImpl accountDao = AccountDaoImpl.getInstance();

    @Test
    public void add() {
        Account account = new Account("bob","987654321","790880528@qq.com");
        try {
            accountDao.add(account);
            log.info("successfully insertion of data");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update() {
        try {

            Account account = accountDao.findByName("cjh");
            account.setPassword("123456789");
            accountDao.update(account);
            Account account1 = accountDao.findByName("cjh");
            if(account1.getPassword().equals("123456789")) {
                log.info("update password successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findByName() {
        try {
            Account account = accountDao.findByName("cjh");
            log.info("find successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() {
        try {
            List<Account> list = accountDao.findAll();
            log.info("success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}