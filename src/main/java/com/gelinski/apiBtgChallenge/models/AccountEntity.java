package com.gelinski.apiBtgChallenge.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "account")
public class AccountEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "id")
    private ClientEntity client;

    @Column(name = "bankNumber", nullable = false, length = 3)
    private String bankNumber;
    @Column(name = "accountNumber", nullable = false, length = 9)
    private String accountNumber;
    @Column(name = "branchNumber", nullable = false, length = 4)
    private String branchNumber;
    @Column(name = "typeAccount", nullable = false, length = 12)
    private String typeAccount;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;
    @Column(name = "openingDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date openingDate;
    @Column(name = "status", nullable = false, length = 12)
    private String status;

    @OneToMany(mappedBy = "account")
    private List<TransactionEntity> transactions;

    public AccountEntity() {}

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
        AccountEntity that = (AccountEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(bankNumber, that.bankNumber) && Objects.equals(accountNumber, that.accountNumber) && Objects.equals(branchNumber, that.branchNumber) && Objects.equals(typeAccount, that.typeAccount) && Objects.equals(balance, that.balance) && Objects.equals(openingDate, that.openingDate) && Objects.equals(status, that.status) && Objects.equals(transactions, that.transactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, bankNumber, accountNumber, branchNumber, typeAccount, balance, openingDate, status, transactions);
    }
}
