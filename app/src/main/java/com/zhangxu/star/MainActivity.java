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
                int[] infrared={R.string.aquarius,R.string.pisces,R.string.aries,R.string.taurus,R.string.gemini,R.string.cancer,R.string.leo,R.string.virgo,R.string.libra,R.string.scorpio,R.string.sagittarius,R.string.capricorns};
                int[] imagery={R.drawable.aquarius,R.drawable.pisces,R.drawable.aries,R.drawable.taurus,R.drawable.gemini,R.drawable.cancer,R.drawable.leo,R.drawable.virgo,R.drawable.libra,R.drawable.scorpio,R.drawable.sagittarius,R.drawable.capricorns,};
                String star=MainActivity.this.getString(infrared[index]);
                text.setText(name.getText().toString()+",你的星座信息如下：\r\n"+star);
                img.setImageResource(imagery[index]);
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

