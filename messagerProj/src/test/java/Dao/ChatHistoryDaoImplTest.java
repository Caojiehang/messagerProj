package Dao;

import bean.PrivateChatHistory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;
/**
* @Author: Jiehang CAO
* @Description: this is for ChatHistoryDao test
* @Date: 19:32 2019-03-21
*/
@Slf4j
public class ChatHistoryDaoImplTest {


    ChatHistoryDaoImpl chatHistoryDao = ChatHistoryDaoImpl.getInstance();
    @Test
    public void add() {
        try {
            PrivateChatHistory record = new PrivateChatHistory("kobe","james","Hello World!", Date.valueOf("2019-3-21"));
            chatHistoryDao.add(record);
            log.info("successfully insertion");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void find() {

        try {
            List<PrivateChatHistory> histories = chatHistoryDao.find("kobe","james",Date.valueOf("2019-3-21"));
            for(PrivateChatHistory history:histories) {
                if(history.getContent().equals("Hello World!")) {
                    log.info("successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}