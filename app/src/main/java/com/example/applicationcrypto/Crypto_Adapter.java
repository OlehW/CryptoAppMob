package com.example.applicationcrypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Crypto_Adapter extends RecyclerView.Adapter<Crypto_Adapter.MyViewHolder> {
    private final DCryptoInterface DCryptoInterface;
    Context context;
    ArrayList<DCryptoWalletOne> DCryptoWalletOnes;

    public Crypto_Adapter(Context context, ArrayList<DCryptoWalletOne> DCryptoWalletOnes,
                          DCryptoInterface DCryptoInterface){
        this.context = context;
        this.DCryptoWalletOnes = DCryptoWalletOnes;
        this.DCryptoInterface = DCryptoInterface;
    }

    @NonNull
    @Override
    public Crypto_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_list, parent, false);
        return new Crypto_Adapter.MyViewHolder(view, DCryptoInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull Crypto_Adapter.MyViewHolder holder, int position) {
        holder.nameWallet.setText(DCryptoWalletOnes.get(position).getNamecrypto());
        holder.btcWallet.setText(DCryptoWalletOnes.get(position).getBtcFirst());
        holder.priceWallet.setText(DCryptoWalletOnes.get(position).getCryptoPrice());
        holder.btcProzentWallet.setText(DCryptoWalletOnes.get(position).getBtcProzent());
        holder.imageView.setImageResource(DCryptoWalletOnes.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return DCryptoWalletOnes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nameWallet, btcWallet, priceWallet, btcProzentWallet;

        public MyViewHolder(@NonNull View itemView, DCryptoInterface DCryptoInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageIcon);
            nameWallet = itemView.findViewById(R.id.nameCrypto);
            btcWallet = itemView.findViewById(R.id.btcFirst);
            priceWallet = itemView.findViewById(R.id.CryptoPrice);
            btcProzentWallet = itemView.findViewById(R.id.btcProzent);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(DCryptoInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            DCryptoInterface.onItemClock(pos);
                        }
                    }
                }
            });
        }
    }
}