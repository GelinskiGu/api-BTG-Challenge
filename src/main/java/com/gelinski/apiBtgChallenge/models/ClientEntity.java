package com.gelinski.apiBtgChallenge.models;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "client")
public class ClientEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @Column(name = "cellPhoneNumber", nullable = false, length = 15)
    private String cellPhoneNumber;
    @Column(name = "maritalStatus", nullable = false, length = 10)
    private String maritalStatus;
    @Column(name = "countryBirth", nullable = false, length = 50)
    private String countryBirth;
    @Column(name = "cityBirth", nullable = false, length = 50)
    private String cityBirth;
    @Column(name = "stateBirth", nullable = false, length = 2)
    private String stateBirth;
    @Column(name = "cityAddress", nullable = false, length = 50)
    private String cityAddress;
    @Column(name = "additionAddress", nullable = true, length = 50)
    private String additionAddress;
    @Column(name = "numberAddress", nullable = false, length = 5)
    private String numberAddress;
    @Column(name = "neighborhood", nullable = false, length = 50)
    private String neighborhood;
    @Column(name = "stateAddress", nullable = false, length = 2)
    private String stateAddress;
    @Column(name = "CPF", nullable = false, length = 11)
    private String CPF;
    @Column(name = "fullName", nullable = false, length = 255)
    private String fullName;
    @Column(name = "CEP", nullable = false, length = 8)
    private String CEP;
    @Column(name = "EUATaxAddress", nullable = true, length = 255)
    private String EUATaxAddress;
    @Column(name = "profession", nullable = false, length = 50)
    private String profession;
    @Column(name = "income", nullable = false, length = 10)
    private BigDecimal income;
    @Column(name = "moveableAssets", nullable = false)
    private BigDecimal moveableAssets = BigDecimal.ZERO;
    @Column(name = "realEstateProperties", nullable = false)
    private BigDecimal realEstateProperties = BigDecimal.ZERO;
    @Column(name = "investments", nullable = false)
    private BigDecimal investments = BigDecimal.ZERO;
    @Column(name = "retirementFunds", nullable = false)
    private BigDecimal retirementFunds = BigDecimal.ZERO;
    @Column(name = "otherPatrimonies", nullable = false)
    private BigDecimal otherPatrimonies = BigDecimal.ZERO;
    @Column(name = "numberDocument", nullable = false, length = 11)
    private String numberDocument;
    @Column(name = "issuerDocument", nullable = false, length = 255)
    private String issuerDocument;
    @Column(name = "typeDocument", nullable = false, length = 3)
    private String typeDocument;
    @Column(name = "backPhotoDocument", nullable = false, length = 255)
    private String backPhotoDocument;
    @Column(name = "frontPhotoDocument", nullable = false, length = 255)
    private String frontPhotoDocument;
    @Column(name = "dateBirth", nullable = false, length = 10)
    private Date dateBirth;
    @Column(name = "selfiePhoto", nullable = false, length = 255)
    private String selfiePhoto;
    @OneToMany(mappedBy = "client")
    private List<AccountEntity> accounts;
    @OneToMany(mappedBy = "client")
    private List<OtherNationality> otherNationalities;

    public ClientEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCountryBirth() {
        return countryBirth;
    }

    public void setCountryBirth(String countryBirth) {
        this.countryBirth = countryBirth;
    }

    public String getCityBirth() {
        return cityBirth;
    }

    public void setCityBirth(String cityBirth) {
        this.cityBirth = cityBirth;
    }

    public String getStateBirth() {
        return stateBirth;
    }

    public void setStateBirth(String stateBirth) {
        this.stateBirth = stateBirth;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getAdditionAddress() {
        return additionAddress;
    }

    public void setAdditionAddress(String additionAddress) {
        this.additionAddress = additionAddress;
    }

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEUATaxAddress() {
        return EUATaxAddress;
    }

    public void setEUATaxAddress(String EUATaxAddress) {
        this.EUATaxAddress = EUATaxAddress;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getMoveableAssets() {
        return moveableAssets;
    }

    public void setMoveableAssets(BigDecimal moveableAssets) {
        this.moveableAssets = moveableAssets;
    }

    public BigDecimal getRealEstateProperties() {
        return realEstateProperties;
    }

    public void setRealEstateProperties(BigDecimal realEstateProperties) {
        this.realEstateProperties = realEstateProperties;
    }

    public BigDecimal getInvestments() {
        return investments;
    }

    public void setInvestments(BigDecimal investments) {
        this.investments = investments;
    }

    public BigDecimal getRetirementFunds() {
        return retirementFunds;
    }

    public void setRetirementFunds(BigDecimal retirementFunds) {
        this.retirementFunds = retirementFunds;
    }

    public BigDecimal getOtherPatrimonies() {
        return otherPatrimonies;
    }

    public void setOtherPatrimonies(BigDecimal otherPatrimonies) {
        this.otherPatrimonies = otherPatrimonies;
    }

    public String getNumberDocument() {
        return numberDocument;
    }

    public void setNumberDocument(String numberDocument) {
        this.numberDocument = numberDocument;
    }

    public String getIssuerDocument() {
        return issuerDocument;
    }

    public void setIssuerDocument(String issuerDocument) {
        this.issuerDocument = issuerDocument;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    public String getBackPhotoDocument() {
        return backPhotoDocument;
    }

    public void setBackPhotoDocument(String backPhotoDocument) {
        this.backPhotoDocument = backPhotoDocument;
    }

    public String getFrontPhotoDocument() {
        return frontPhotoDocument;
    }

    public void setFrontPhotoDocument(String frontPhotoDocument) {
        this.frontPhotoDocument = frontPhotoDocument;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSelfiePhoto() {
        return selfiePhoto;
    }

    public void setSelfiePhoto(String selfiePhoto) {
        this.selfiePhoto = selfiePhoto;
    }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    public List<OtherNationality> getOtherNationalities() {
        return otherNationalities;
    }

    public void setOtherNationalities(List<OtherNationality> otherNationalities) {
        this.otherNationalities = otherNationalities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(cellPhoneNumber, that.cellPhoneNumber) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(countryBirth, that.countryBirth) && Objects.equals(cityBirth, that.cityBirth) && Objects.equals(stateBirth, that.stateBirth) && Objects.equals(cityAddress, that.cityAddress) && Objects.equals(additionAddress, that.additionAddress) && Objects.equals(numberAddress, that.numberAddress) && Objects.equals(neighborhood, that.neighborhood) && Objects.equals(stateAddress, that.stateAddress) && Objects.equals(CPF, that.CPF) && Objects.equals(fullName, that.fullName) && Objects.equals(CEP, that.CEP) && Objects.equals(EUATaxAddress, that.EUATaxAddress) && Objects.equals(profession, that.profession) && Objects.equals(income, that.income) && Objects.equals(moveableAssets, that.moveableAssets) && Objects.equals(realEstateProperties, that.realEstateProperties) && Objects.equals(investments, that.investments) && Objects.equals(retirementFunds, that.retirementFunds) && Objects.equals(otherPatrimonies, that.otherPatrimonies) && Objects.equals(numberDocument, that.numberDocument) && Objects.equals(issuerDocument, that.issuerDocument) && Objects.equals(typeDocument, that.typeDocument) && Objects.equals(backPhotoDocument, that.backPhotoDocument) && Objects.equals(frontPhotoDocument, that.frontPhotoDocument) && Objects.equals(dateBirth, that.dateBirth) && Objects.equals(selfiePhoto, that.selfiePhoto) && Objects.equals(accounts, that.accounts) && Objects.equals(otherNationalities, that.otherNationalities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, cellPhoneNumber, maritalStatus, countryBirth, cityBirth, stateBirth, cityAddress, additionAddress, numberAddress, neighborhood, stateAddress, CPF, fullName, CEP, EUATaxAddress, profession, income, moveableAssets, realEstateProperties, investments, retirementFunds, otherPatrimonies, numberDocument, issuerDocument, typeDocument, backPhotoDocument, frontPhotoDocument, dateBirth, selfiePhoto, accounts, otherNationalities);
    }
}
