/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author 503
 */


public class userRegister implements Serializable {

    private String userName;
    private String password;
    private String email;

        public userRegister() {
        }

        public userRegister(String userName, String password, String email) {
            this.userName = userName;
            this.password = password;
            this.email = email;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public String getEmail() {
            return email;
        }
    
}
