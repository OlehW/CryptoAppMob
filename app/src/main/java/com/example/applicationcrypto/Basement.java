package com.example.applicationcrypto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Basement extends AppCompatActivity implements DCryptoInterface {

    ArrayList<DCryptoWalletOne> DCryptoWalletOnes = new ArrayList<>();

    int[] DCryptoWalletImages = {R.drawable.bitcoin, R.drawable.ic_etherum, R.drawable.ic_tether,
            R.drawable.ic_usd_coin, R.drawable.ic_ripple, R.drawable.ic_cardano, R.drawable.ic_solana,
            R.drawable.ic_tron, R.drawable.ic_litecoin, R.drawable.ic_avax, R.drawable.ic_shib,
            R.drawable.ic_chainlink, R.drawable.ic_cosmos, R.drawable.ic_monero, R.drawable.ic_lumen};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basement);

        //реалізація списку
        RecyclerView recyclerView = findViewById(R.id.list);

        setDCryptoWalletOnes();

        Crypto_Adapter adapter = new Crypto_Adapter(this, DCryptoWalletOnes, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //реалізація списку
    private void setDCryptoWalletOnes() {
        String[] DCryptoWalletNames = getResources().getStringArray(R.array.full_name);
        String[] DCryptoWalletSmallNames = getResources().getStringArray(R.array.small_name);
        String[] DCryptoWalletPrice = getResources().getStringArray(R.array.price_name);
        String[] DCryptoWalletProzent = getResources().getStringArray(R.array.prozent_name);

        for (int i = 0; i < DCryptoWalletNames.length; i++) {
            DCryptoWalletOnes.add(new DCryptoWalletOne(DCryptoWalletNames[i],
                    DCryptoWalletSmallNames[i], DCryptoWalletPrice[i], DCryptoWalletProzent[i],
                    DCryptoWalletImages[i]));
        }
    }

    //реалізація списку при натисканні
    @Override
    public void onItemClock(int position) {
        Intent intent = new Intent(Basement.this, OpenListActivity.class);

        intent.putExtra("NAMECRYPTOOPENS", DCryptoWalletOnes.get(position).getNamecrypto());
        intent.putExtra("BTCFIRSTOPENS", DCryptoWalletOnes.get(position).getBtcFirst());
        intent.putExtra("CRYPTOPRICEOPENS", DCryptoWalletOnes.get(position).getCryptoPrice());
        intent.putExtra("BTCPROZENTOPENS", DCryptoWalletOnes.get(position).getBtcProzent());
        intent.putExtra("IMAGE", DCryptoWalletOnes.get(position).getImage());

        startActivity(intent);
    }
}