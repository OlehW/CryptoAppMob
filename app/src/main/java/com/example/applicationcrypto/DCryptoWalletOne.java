package com.example.applicationcrypto;

public class DCryptoWalletOne {
    private String namecrypto;
    private String btcFirst;
    private String CryptoPrice;
    private String btcProzent;
    int image;

    public DCryptoWalletOne(String namecrypto, String btcFirst, String CryptoPrice, String btcProzent, int image) {
        this.namecrypto = namecrypto;
        this.btcFirst = btcFirst;
        this.CryptoPrice = CryptoPrice;
        this.btcProzent = btcProzent;
        this.image = image;
    }

    public String getNamecrypto() {
        return namecrypto;
    }
    public String getBtcFirst() {
        return btcFirst;
    }
    public String getCryptoPrice() {
        return CryptoPrice;
    }
    public String getBtcProzent() {
        return btcProzent;
    }
    public int getImage() {
        return image;
    }
}