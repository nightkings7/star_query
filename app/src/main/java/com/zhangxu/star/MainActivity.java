package com.zhangxu.star;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    DatePicker date;
    Button btn;
    ImageView img;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=this.findViewById(R.id.editName);
        date=this.findViewById(R.id.dataPicker);
        btn=this.findViewById(R.id.button);
        img=this.findViewById(R.id.imageView);
        text=this.findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int month=date.getMonth();
                int day=date.getDayOfMonth();
                int index=searchStar(month,day);
                int[] infoarray={1,2,3,4,5,6,7,8,9,10,11,12};
                int[] imgarray={1,2,3,4,5,6,7,8,9,10,11,12};
                String star=MainActivity.this.getString(infoarray[index]);
                text.setText(name.getText().toString()+",你的星座信息如下：\r\n"+star);
                img.setImageResource(imgarray[index]);
            }
        });
    }
    public int searchStar(int month, int day){
        int[] days={20,19,21,20,21,22,23,23,23,24,23,22};
        int index=month;
        if(day<days[month]){
            index=index-1;
            if (index<0){
                index=11;
            }
        }
        return index;
    }
}

