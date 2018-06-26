package com.example.apurv.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView et;
    TextView tv;
final String operators="+-/*()";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et=findViewById(R.id.et);
        tv=findViewById(R.id.tv);

        //line 1
        Button bac=findViewById(R.id.ac);
        bac.setOnClickListener(this);
        Button bclear=findViewById(R.id.clear);
        bclear.setOnClickListener(this);
        Button bbracket2=findViewById(R.id.bracket2);
        bbracket2.setOnClickListener(this);
        Button bdivide=findViewById(R.id.divide);
        bdivide.setOnClickListener(this);

        //line 2
        Button b7=findViewById(R.id.seven);
        b7.setOnClickListener(this);
        Button b8=findViewById(R.id.eight);
        b8.setOnClickListener(this);
        Button b9=findViewById(R.id.nine);
        b9.setOnClickListener(this);
        Button bmultiply=findViewById(R.id.multiply);
        bmultiply.setOnClickListener(this);

        //line 3
        Button b4=findViewById(R.id.four);
        b4.setOnClickListener(this);
        Button b5=findViewById(R.id.five);
        b5.setOnClickListener(this);
        Button b6=findViewById(R.id.six);
        b6.setOnClickListener(this);
        Button bsubtract=findViewById(R.id.subtract);
        bsubtract.setOnClickListener(this);

        //line 4
        Button b1=findViewById(R.id.one);
        b1.setOnClickListener(this);
        Button b2=findViewById(R.id.two);
        b2.setOnClickListener(this);
        Button b3=findViewById(R.id.three);
        b3.setOnClickListener(this);
        Button bplus=findViewById(R.id.plus);
        bplus.setOnClickListener(this);


        //line 5
        Button b0=findViewById(R.id.zero);
        b0.setOnClickListener(this);
        Button bbracket1=findViewById(R.id.bracket1);
        bbracket1.setOnClickListener(this);
        Button bdecimal=findViewById(R.id.decimal);
        bdecimal.setOnClickListener(this);
        Button bequal=findViewById(R.id.equal);
        bequal.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        int id=view.getId();

try {
    if (id == R.id.ac) {
        et.setText("");
        tv.setText("");

    } else if (id == R.id.clear) {
        String s=et.getText().toString();
        if(s.length()==0||s.length()==1)
        {
            et.setText("");
        }
        else
        {
           String temp=s.substring(0,s.length()-1);
           et.setText(temp);
        }

        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.bracket2)
    {
        et.setText(et.getText()+")");
    }
    else if(id==R.id.divide)
    {
        et.setText(et.getText()+"/");
    }
    else if(id==R.id.seven)
    {
        et.setText(et.getText()+"7");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.eight)
    {
        et.setText(et.getText()+"8");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.nine)
    {
        et.setText(et.getText()+"9");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.multiply)
    {
        et.setText(et.getText()+"*");
    }
    else if(id==R.id.four)
    {
        et.setText(et.getText()+"4");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.five)
    {
        et.setText(et.getText()+"5");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.six)
    {
        et.setText(et.getText()+"6");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.subtract)
    {


        et.setText(et.getText()+"-");
    }
    else if(id==R.id.one)
    {
        et.setText(et.getText()+"1");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.two)
    {
        et.setText(et.getText()+"2");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.three)
    {
        et.setText(et.getText()+"3");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.plus)
    {
        et.setText(et.getText()+"+");
    }
    else if(id==R.id.zero)
    {
        et.setText(et.getText()+"0");
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }
    else if(id==R.id.bracket1)
    {
        et.setText(et.getText()+"(");
    }
    else if(id==R.id.decimal)
    {
        et.setText(et.getText()+".");
    }
    else if(id==R.id.equal)
    {
        tv.setText(Float.toString(Evaluate.evaluate(process(et.getText().toString()))));
    }

    else
    {
        Toast.makeText(getApplicationContext(), "WRONG CLICK", Toast.LENGTH_SHORT).show();
    }
}catch(Exception exp)
        {

            tv.setText("");

            Toast.makeText(getApplicationContext(), "WRONG FORMAT", Toast.LENGTH_SHORT).show();
        }
    }

    public  String process(String exp)
    {
        String temp="";


        for(int i=0;i<exp.length();i++)
        {
            if(i==0&&exp.charAt(i)=='-')
            {
                temp=temp+"(0-";
                i++;
                      while(i<exp.length()&&!operators.contains(Character.toString(exp.charAt(i))))
                {
                    temp=temp+exp.charAt(i);
                    i++;
                }
                i--;
                temp=temp+")";
            }
            else if(exp.charAt(i)=='-'&&operators.contains(Character.toString(exp.charAt(i-1))))
            {
                temp=temp+"(0-";
                i++;
                while(i<exp.length()&&!operators.contains(Character.toString(exp.charAt(i))))
                {
                    temp=temp+exp.charAt(i);
                    i++;
                }
                i--;
                temp=temp+")";
            }
            else
            {
                temp=temp+exp.charAt(i);
            }
        }
        Toast.makeText(getApplicationContext(),temp,Toast.LENGTH_LONG).show();
        return temp;

    }


}
