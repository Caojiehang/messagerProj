package Dao;

import bean.PrivateChatHistory;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
/**
* @Author: Jiehang CAO, Fiona Li
* @Description:
* @Date: 11:30 2019-03-17
*/
public interface ChatHistoryDao  {
    // add chat history to database
    public void add(PrivateChatHistory privateChatHistory) throws SQLException;
    // find chat history record in databases
    public List<PrivateChatHistory> find(String receiver, String sender, Date send_time) throws SQLException;


}
