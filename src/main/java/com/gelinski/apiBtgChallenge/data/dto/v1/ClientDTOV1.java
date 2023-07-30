package com.gelinski.apiBtgChallenge.data.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gelinski.apiBtgChallenge.models.AccountEntity;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class ClientDTOV1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String cellPhoneNumber;
    private String maritalStatus;
    private String countryBirth;
    private String cityBirth;
    private String stateBirth;
    private String cityAddress;
    private String additionAddress;
    private String numberAddress;
    private String neighborhood;
    private String stateAddress;
    private String cpf;
    private String fullName;
    private String cep;
    private String EUATaxAddress;
    private String profession;
    private BigDecimal income;
    private BigDecimal moveableAssets = BigDecimal.ZERO;
    private BigDecimal realEstateProperties = BigDecimal.ZERO;
    private BigDecimal investments = BigDecimal.ZERO;
    private BigDecimal retirementFunds = BigDecimal.ZERO;
    private BigDecimal otherPatrimonies = BigDecimal.ZERO;
    private String numberDocument;
    private String issuerDocument;
    private String typeDocument;
    private String backPhotoDocument;
    private String frontPhotoDocument;
    private String dateBirth;
    private String selfiePhoto;
    private String otherNationality;
    @JsonIgnoreProperties({"client", "transactions"})
    private List<AccountEntity> accounts;

    public ClientDTOV1() {}

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSelfiePhoto() {
        return selfiePhoto;
    }

    public void setSelfiePhoto(String selfiePhoto) {
        this.selfiePhoto = selfiePhoto;
    }

    public String getOtherNationality() {
        return otherNationality;
    }

    public void setOtherNationality(String otherNationality) {
        this.otherNationality = otherNationality;
    }

    public List<AccountEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountEntity> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTOV1 that = (ClientDTOV1) o;
        return Objects.equals(id, that.id) && Objects.equals(email, that.email) && Objects.equals(cellPhoneNumber, that.cellPhoneNumber) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(countryBirth, that.countryBirth) && Objects.equals(cityBirth, that.cityBirth) && Objects.equals(stateBirth, that.stateBirth) && Objects.equals(cityAddress, that.cityAddress) && Objects.equals(additionAddress, that.additionAddress) && Objects.equals(numberAddress, that.numberAddress) && Objects.equals(neighborhood, that.neighborhood) && Objects.equals(stateAddress, that.stateAddress) && Objects.equals(cpf, that.cpf) && Objects.equals(fullName, that.fullName) && Objects.equals(cep, that.cep) && Objects.equals(EUATaxAddress, that.EUATaxAddress) && Objects.equals(profession, that.profession) && Objects.equals(income, that.income) && Objects.equals(moveableAssets, that.moveableAssets) && Objects.equals(realEstateProperties, that.realEstateProperties) && Objects.equals(investments, that.investments) && Objects.equals(retirementFunds, that.retirementFunds) && Objects.equals(otherPatrimonies, that.otherPatrimonies) && Objects.equals(numberDocument, that.numberDocument) && Objects.equals(issuerDocument, that.issuerDocument) && Objects.equals(typeDocument, that.typeDocument) && Objects.equals(backPhotoDocument, that.backPhotoDocument) && Objects.equals(frontPhotoDocument, that.frontPhotoDocument) && Objects.equals(dateBirth, that.dateBirth) && Objects.equals(selfiePhoto, that.selfiePhoto) && Objects.equals(otherNationality, that.otherNationality) && Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, cellPhoneNumber, maritalStatus, countryBirth, cityBirth, stateBirth, cityAddress, additionAddress, numberAddress, neighborhood, stateAddress, cpf, fullName, cep, EUATaxAddress, profession, income, moveableAssets, realEstateProperties, investments, retirementFunds, otherPatrimonies, numberDocument, issuerDocument, typeDocument, backPhotoDocument, frontPhotoDocument, dateBirth, selfiePhoto, otherNationality, accounts);
    }
}
