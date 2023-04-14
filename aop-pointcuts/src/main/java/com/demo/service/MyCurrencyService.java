package com.demo.service;

import com.demo.annotation.Secured;
import com.demo.annotation.Transaction;
import com.demo.ds.CurrencyType;
import org.springframework.stereotype.Component;

@Component("my_bean") @Secured
public class MyCurrencyService {

    @Transaction
    public void changeCurrency(int num, double rate){

    }

    public void changeCurrency() {

    }

    public void currencyLongName(CurrencyType currencyType){

    }

    public String currencyCountryName(CurrencyType currencyType){
        if (currencyType.equals(CurrencyType.US)) {
            return "US";
        }
        throw new IllegalArgumentException("Error!");
    }
}
