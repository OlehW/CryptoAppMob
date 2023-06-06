package com.example.applicationcrypto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;


public class OpenListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_list);

        //вивід для натискання на список
        String NameCryptoOpens = getIntent().getStringExtra("NAMECRYPTOOPENS");
        String BtcFirstOpens = getIntent().getStringExtra("BTCFIRSTOPENS");
        String CryptoPriceOpens = getIntent().getStringExtra("CRYPTOPRICEOPENS");
        String BtcProzentOpens = getIntent().getStringExtra("BTCPROZENTOPENS");
        int image = getIntent().getIntExtra("IMAGE", 0);

        TextView NameCryptoOpensEnd = findViewById(R.id.nameCrypto);
        TextView BtcFirstOpensEnd = findViewById(R.id.btcFirst);
        TextView CryptoPriceOpensEnd = findViewById(R.id.CryptoPrice);
        TextView BtcProzentOpensEnd = findViewById(R.id.btcProzent);
        ImageView imageEnd = findViewById(R.id.imageIcon);

        NameCryptoOpensEnd.setText(NameCryptoOpens);
        BtcFirstOpensEnd.setText(BtcFirstOpens);
        CryptoPriceOpensEnd.setText(CryptoPriceOpens);
        BtcProzentOpensEnd.setText(BtcProzentOpens);
        imageEnd.setImageResource(image);

        //Створення графіка
        LineChart lineChart = findViewById(R.id.graphic);

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 10));
        entries.add(new Entry(1, 20));
        entries.add(new Entry(2, 15));
        entries.add(new Entry(3, 25));
        entries.add(new Entry(4, 18));

        LineDataSet lineDataSet = new LineDataSet(entries, "Wave Line");
        lineDataSet.setColor(getResources().getColor(R.color.orange));
        lineDataSet.setLineWidth(2f);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);

        LineData lineData = new LineData(dataSets);

        lineChart.setData(lineData);

        lineChart.getLegend().setEnabled(false);

        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);

        lineChart.getXAxis().setEnabled(false);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.getAxisRight().setEnabled(false);

        lineChart.getAxisLeft().setDrawGridLines(false);
        lineChart.getXAxis().setDrawGridLines(false);

        lineChart.setDrawMarkers(false);

        lineChart.invalidate();
    }
}