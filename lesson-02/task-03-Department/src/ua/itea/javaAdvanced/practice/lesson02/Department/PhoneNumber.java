package ua.itea.javaAdvanced.practice.lesson02.Department;

import java.util.Objects;

public class PhoneNumber implements Cloneable{
    private String countryCode;
    private String operatorCode;
    private String subscriberNumber;
    private String fullNumber;

    PhoneNumber(String subscriberNumber){
        this.countryCode = "";
        this.operatorCode = "";
        this.subscriberNumber = subscriberNumber;
        fullNumber = composeNumber();
    }

    PhoneNumber(String operatorCode, String subscriberNumber){
        this.countryCode = "";
        this.operatorCode = operatorCode;
        this.subscriberNumber = subscriberNumber;
        fullNumber = composeNumber();
    }

    PhoneNumber(String countryCode, String operatorCode, String subscriberNumber){
        this.countryCode = countryCode;
        this.operatorCode = operatorCode;
        this.subscriberNumber = subscriberNumber;
        fullNumber = composeNumber();
    }

    //копирующий конструктор
    public PhoneNumber(PhoneNumber another) {
        this(another.getCountryCode(), another.getOperatorCode(), another.getSubscriberNumber());
    }

    private String composeNumber(){
        if (countryCode.isEmpty() && operatorCode.isEmpty()){
            return subscriberNumber;
        }
        if (countryCode.isEmpty()){
            return operatorCode + " " + subscriberNumber;
        }
        return "+" + countryCode + " " + operatorCode.substring(1) + " " + subscriberNumber;
    }

    String getCountryCode(){
        return countryCode;
    }

    String getOperatorCode() {
        return operatorCode;
    }

    String getSubscriberNumber() {
        return subscriberNumber;
    }

    String getFullNumber() {
        return fullNumber;
    }

    @Override
    public String toString() {
        return composeNumber();
    }

    @Override
    public int hashCode(){
        return Objects.hash(countryCode, operatorCode, subscriberNumber, fullNumber);
    }

    @Override
    public boolean equals(Object another){
        if (this == another) return true;
        if (another == null) return false;
        if (this.getClass() != another.getClass()) return false;
        PhoneNumber pn = (PhoneNumber) another;
        return (countryCode.equals(pn.countryCode) && operatorCode.equals(pn.operatorCode) &&
                subscriberNumber.equals(pn.subscriberNumber) && fullNumber.equals(pn.fullNumber));
    }

    @Override
    public PhoneNumber clone(){
        PhoneNumber copy;
        try{
            copy = (PhoneNumber)super.clone();
        } catch (CloneNotSupportedException ex){
            throw new AssertionError("Does class implement Cloneable?");
        }
        return copy;
    }
}
