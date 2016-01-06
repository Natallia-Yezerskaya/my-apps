package com.test.lesson18.events;

import com.test.lesson18.models.Currency;

/**
 * Created by USER on 06.01.2016.
 */
public class CurrencyResponse {
    private boolean error;
    private Currency currency;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
