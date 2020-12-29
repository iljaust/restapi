package com.iljaust.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iljaust.model.AccountStatus;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    private Long id;
    private String data;
    private AccountStatus accountStatus;

    public AccountDTO(Long id, String data, AccountStatus accountStatus){
        this.id = id;
        this.data = data;
        this.accountStatus = accountStatus;
    }

    public AccountDTO(){

    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getData() {

        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    public AccountStatus getAccountStatus() {

        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {

        this.accountStatus = accountStatus;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", accountStatus=" + accountStatus +
                '}';
    }
}
