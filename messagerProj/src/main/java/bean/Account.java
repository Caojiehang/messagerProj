package bean;

import lombok.Data;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
* @Author: Jiehang CAO
* @Description: Account bean
* @Date: 17:35 2019-03-03
*/
@Data
public class Account {
    /**
     * Username
     */
    private String username;
    /**
     * Password
     */
    private String password;
    /**
     * id primary key
     */

    private int id;

    /**
     * users'status  online or offline
     */
    private String status;

    /**
     * email
     */
    private String email;


    /**
     * to store users message
     */
    private Queue<String> session;


    public Account (int id,String username,String password,String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        session = new ConcurrentLinkedQueue<>();
    }
    public Account( String username, String password,String email) {
        //this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        session = new ConcurrentLinkedQueue<>();
    }


    public Account() {
      new Account(null,null,null)  ;
    }

    /**
     * add message to session
     * @param message
     */
    public void addMsg(String message) {
        session.offer(message);
    }

    /**
     * get messages session
     * @return
     */
    public String getMsg() {
        if(session.isEmpty()) {
            return  null;
        }
        return session.poll();
    }

}
