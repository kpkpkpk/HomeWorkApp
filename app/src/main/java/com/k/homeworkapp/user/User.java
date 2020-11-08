package com.k.homeworkapp.user;

import java.util.HashMap;
import java.util.Objects;

public class User {
  private static HashMap<String,Integer> userList=new HashMap<String, Integer>();
    public User(String name,String password){
        userList.put(name,User.hashCode(password));
    }

   public static boolean isExist(String inputLogin,String inputPassword){

        if(userList.containsKey(inputLogin)&&userList.get(inputLogin)==User.hashCode(inputPassword)){
            return true;
        }else{
            return false;
        }
   }


    private static int hashCode(String password) {
        return Objects.hash(password);
    }
}
