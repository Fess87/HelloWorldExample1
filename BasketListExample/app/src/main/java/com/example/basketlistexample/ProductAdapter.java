package com.example.basketlistexample;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {

    List<Product> listproducts;
    LayoutInflater layoutInflater;
    Context ctx;

    ProductAdapter(Context context, List<Product> products) {
        this.listproducts = products;
        ctx = context;
        layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listproducts.size();
    }

    @Override
    public Object getItem(int position) {
        return listproducts.get(position);
    }

    public Product getProduct(int position) {
        return listproducts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null){
            view = layoutInflater.inflate(R.layout.basket_item_layout, parent,false);
        }
        final Product product = getProduct(position);

        TextView itemName = view.findViewById(R.id.itemName);
        TextView itemDescription = view.findViewById(R.id.itemDescription);
        TextView itemQuantity = view.findViewById(R.id.itemQuantity);
        TextView itemPrice = view.findViewById(R.id.itemPrice);
        ImageView itemImage = view.findViewById(R.id.itemIcon);
        CheckBox itemSelected = view.findViewById(R.id.selectedItem);
        itemName.setText(product.getName());
        itemDescription.setText("Описание:\n" + product.getDescription());
        itemQuantity.setText("Кол-во: "+product.getQuantity()+"шт.");
        itemPrice.setText(product.getPrice()+".00 руб.");
        itemImage.setImageResource(product.getImage());
        itemSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listproducts.get((Integer) buttonView.getTag()).setChecked(isChecked);
            }
        });
        itemSelected.setTag(position);
        itemSelected.setChecked(product.isCheckbox());

        return view;
    }
}
