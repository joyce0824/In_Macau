package com.joyce.kuo.inmacau.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.joyce.kuo.inmacau.R;

public class ListActivity extends AppCompatActivity {
    ListView lv1;
    String[] str={"護照正本、台胞證", "護照影本、2吋照片X2","錢包(信用卡、澳門幣、港幣、人民幣)", "變電器","轉接插頭","筆電"
            ,"電子機票", "訂房憑證/機場接送電話", "行李箱鎖／鑰匙", "旅行行程表","夾鏈袋"
            ,"筆、筆記本","手機", "行動電源/電池","傳輸線","耳機","網路分享器","記憶卡"
            ,"雨傘", "自拍神器" ,"衛生紙", "小水瓶" ,"毛巾／浴巾","(隱形)眼鏡","生理食鹽水"
            ,"泳衣" ,"雪衣、雪帽、風衣、圍巾","塑膠袋","眼罩","外衣、外褲、外套","襪子","睡衣"
            ,"內衣褲、免洗褲" ,"帽子", "OK繃、棉花棒","防曬用品", "涼鞋/拖鞋", "背包","衣架","盥洗用具(牙刷、牙膏、洗面乳)"
            ,"化妝水","護髮霜","面膜","乳液","護手霜","護唇膏","眉筆","粉餅","眼線筆","睫毛膏","假睫毛","腮紅","口紅","髮蠟","卸妝"
            ,"胃藥","暈車藥","眼藥水","感冒藥","防蚊液","燒燙傷藥","過敏藥"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lv1=(ListView)findViewById(R.id.listView);
        ListAdapter adapter=new ListAdapter(ListActivity.this,str);
        lv1.setAdapter(adapter);
    }
}