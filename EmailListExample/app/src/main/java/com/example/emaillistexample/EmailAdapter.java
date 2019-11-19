package com.example.emaillistexample;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class EmailAdapter extends BaseAdapter {

    ArrayList<ItemMail> arrayEmails;
    LayoutInflater layoutInflater;
    Context ctx;

    EmailAdapter(Context context, ArrayList<ItemMail> emails){
        ctx=context;
        emails = arrayEmails;
        layoutInflater= (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return arrayEmails.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayEmails.get(position);
    }

    public ItemMail getItemEmail(int position) {
        return arrayEmails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private CompoundButton.OnCheckedChangeListener myCheckChangeList
            = new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isBox) {
            arrayEmails.get((Integer) buttonView.getTag()).setBox(isBox);
        }
    };

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null){
            view = layoutInflater.inflate(R.layout.mail_item_layout,parent, false);
        }
        ItemMail itemMail = getItemEmail(position);
        ImageView icon = view.findViewById(R.id.iconSender);
        TextView sender = view.findViewById(R.id.sender);
        TextView headEmail = view.findViewById(R.id.headEmail);
        TextView emailText = view.findViewById(R.id.emailText);
        TextView receiptTime = view.findViewById(R.id.receiptTime);
        CheckBox checkBox = view.findViewById(R.id.selected);
        sender.setText(itemMail.senderName);
        headEmail.setText(itemMail.headEmail);
        emailText.setText(itemMail.textEmail);
        receiptTime.setText(itemMail.time.format(DateTimeFormatter.ISO_LOCAL_TIME).toString());
        icon.setImageDrawable (itemMail.getImage());
        checkBox.setOnCheckedChangeListener(myCheckChangeList);
        checkBox.setTag(position);
        checkBox.setChecked(itemMail.isBox());

        return null;
    }
}
