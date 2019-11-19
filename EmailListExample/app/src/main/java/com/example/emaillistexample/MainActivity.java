package com.example.emaillistexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    private void initListView(){
        ListView list = findViewById(R.id.list);
        ArrayList<ItemMail> emails = new ArrayList<>();
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",(R.drawable.ic_launcher_background),false ));
        emails.add(new ItemMail("ChinaSpam","Уважаемый(ая)! Скидки до 95% на Красивые модные топы","Блаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблаблабла",R.mipmap.ic_launcher,true ));
        emails.add(new ItemMail("GeekBrains","Black Friday x 7 = ?","Привет!\n"+"\n"+"Давайте поговорим о Black Friday начистоту.\n"+"\n"+"Первое. Мы не будем томить вас ожиданиями и «подготовками», а честно проведем «Черную Пятницу» раньше.\n"+"\n"+"Второе. Чтобы вы все успели, мы сделали не одну пятницу, а целых семь. Семь дней больших скидок. Начиная с сегодня.\n"+"\n"+"— 30 000 рублей\n"+"на все факультеты GeekUniversity\n"+"\n"+"— 30%\n"+"на все профессии",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        emails.add(new ItemMail("GitHub","Say Hello World and get into the GitHub Flow","There are plenty of resources out there to help you navigate GitHub. Create projects, open pull requests, and get into the flow.",R.mipmap.ic_launcher,false ));
        BaseAdapter adapter = new EmailAdapter(this,emails);
        list.setAdapter(adapter);
    }
}
