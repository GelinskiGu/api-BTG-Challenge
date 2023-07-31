package com.gelinski.apiBtgChallenge.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import com.gelinski.apiBtgChallenge.models.TransactionEntity;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class AccountDTOV1 implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long clientId;
    @JsonIgnore
    private ClientEntity client;
    private String bankNumber;
    private String accountNumber;
    private String branchNumber;
    private String typeAccount;
    private BigDecimal balance = BigDecimal.ZERO;
    private Date openingDate = new Date();
    private String status;

    @JsonIgnoreProperties({"account", "clients"})
    private List<TransactionEntity> transactions;

    public AccountDTOV1() {}

    @JsonProperty("client_id")
    public Long getClientId() {
        return this.client != null ? this.client.getId() : null;
    }

    @JsonProperty("client_id")
    public void setClientId(Long clientId) {
        this.clientId = clientId;
        if (this.client == null) {
            this.client = new ClientEntity();
        }
        this.client.setId(clientId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTOV1 that = (AccountDTOV1) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(bankNumber, that.bankNumber) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(branchNumber, that.branchNumber) && Objects.equals(typeAccount, that.typeAccount) && Objects.equals(balance, that.balance) && Objects.equals(openingDate, that.openingDate) && Objects.equals(status, that.status) && Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, bankNumber, accountNumber, branchNumber, typeAccount, balance, openingDate, status, transactions);
    }
}
