package model;

public class ConversionResponse {

    private String currencyName;
    private double value;

    public ConversionResponse() {
    }

    public ConversionResponse(String currencyName, double value) {
        this.currencyName = currencyName;
        this.value = value;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
