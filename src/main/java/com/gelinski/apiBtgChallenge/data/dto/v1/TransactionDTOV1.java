package com.gelinski.apiBtgChallenge.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class TransactionDTOV1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long accountId;
    @JsonIgnore
    private AccountEntity account;
    private Date transactionDate = new Date();
    private BigDecimal amount;
    private String transactionType;

    public TransactionDTOV1() {}

    @JsonProperty("account_id")
    public Long getAccountId() {
        return this.account != null ? this.account.getId() : null;
    }

    @JsonProperty("account_id")
    public void setAccountId(Long clientId) {
        this.accountId = accountId;
        if (this.account == null) {
            this.account = new AccountEntity();
        }
        this.account.setId(clientId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountEntity getAccount() {
        return account;
    }

    public void setAccount(AccountEntity account) {
        this.account = account;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDTOV1 that = (TransactionDTOV1) o;
        return Objects.equals(id, that.id) && Objects.equals(account, that.account) && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(amount, that.amount) && Objects.equals(transactionType, that.transactionType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, transactionDate, amount, transactionType);
    }
}
