package model;

public class ExchangeHistorial {

    private double value;
    private String currencyType;
    private double result;

    public ExchangeHistorial(double value, String currencyType, double result) {
        this.value = value;
        this.currencyType = currencyType;
        this.result = result;
    }

    public ExchangeHistorial() {

    }


    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
