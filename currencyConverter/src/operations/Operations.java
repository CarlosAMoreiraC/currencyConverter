package operations;

import model.CurrencyResponse;
import model.ExchangeHistorial;

import java.util.ArrayList;
import java.util.List;

public class Operations {

    private CurrencyResponse currencyResponse;
    private List<ExchangeHistorial> exchangeHistorialList = new ArrayList<ExchangeHistorial>();

    public List<ExchangeHistorial> getExchangeHistorialList() {
        return exchangeHistorialList;
    }

    public void setExchangeHistorialList(List<ExchangeHistorial> exchangeHistorialList) {
        this.exchangeHistorialList = exchangeHistorialList;
    }

    public Operations(CurrencyResponse currencyResponse) {
        this.currencyResponse = currencyResponse;
    }

    public double convertValue(double value, int currencyType) {
        String currencyTypeName = "";
        double valueResponse;
        switch (currencyType) {
             case 1: valueResponse = value * this.currencyResponse.conversion_rates().USD();
                    currencyTypeName = "USD";
             break;
             case 2: valueResponse = value * this.currencyResponse.conversion_rates().AED();
                 currencyTypeName = "AED";
             break;
             default: valueResponse = value * this.currencyResponse.conversion_rates().COP();
                 currencyTypeName = "COP";
             break;
        };
        ExchangeHistorial exchangeHistorial = new ExchangeHistorial(value, currencyTypeName, valueResponse);
        this.exchangeHistorialList.add(exchangeHistorial);
        return valueResponse;
    }
}
