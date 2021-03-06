package com.example.spring_movie_app.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AccountDetails extends User {

    /**
     * ユーザID
     */
    private Long userId;

    /**
     * ユーザ名
     */
    private String userName;

    /**
     * コンストラクタ
     * Spring Securityで認証するためのユーザ情報を設定する
     *
     * @param userId        ユーザID
     * @param userName      ユーザ名
     * @param password      パスワード
     * @param authorities   ロール情報
     */
    public AccountDetails(Long userId,
                          String userName,
                          String password,
                          Collection<? extends GrantedAuthority> authorities
                          ) {
        super(userName, password, authorities);
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
