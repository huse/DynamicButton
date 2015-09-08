package com.kpr.hus.dynamicbutton;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends ActionBarActivity {
    Double num1=0.0;
    Double num2=0.0;
    Double result= 0.0;
    Double memory=0.0;
    Double minus = 0.0;
    Character operator = ' ';
    Character operatorSign=' ';
    HashMap<Integer,ArrayList<Integer>> position= new HashMap<Integer,ArrayList<Integer>>();

    int alpha = 155;
    int shake=0;
    int nineHeight;
    int twoNineHeight;
    int textNineHeight;
    int textButtonSize;
    int forthWidth;
    boolean progress= true;

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
{

}
    Button btMS,btMC,btMR,btBack,bt1,bt2,bt3,btClear,bt4,bt5,bt6,btAdd,bt7,bt8,bt9,btSub,btDot,bt0,btEqual,btMulti,btPow,btSqrt,btMinus,btDevide;

    public void widthHeight(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;
        nineHeight=height/9;
        twoNineHeight= nineHeight  * 18/10;
        textNineHeight= nineHeight/12;
        textButtonSize= nineHeight/8;
        forthWidth = width / 4;
        // Creating a new RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters with Fill_Parent
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);

        final TextView tvMemory = new TextView(this);
        tvMemory.setText("M: ");
        tvMemory.setTextSize(textNineHeight);
        final TextView mem = new TextView(this);
        mem.setText("2343");
        mem.setTextSize(textNineHeight);
        final TextView tvN1 = new TextView(this);
        tvN1.setText("width");
        tvN1.setTextSize(textNineHeight);
        final TextView tvOpt = new TextView(this);
        tvOpt.setText("+");
        tvOpt.setTextSize(textNineHeight);
        tvOpt.setTextColor(0xFFF06D2F);
        final TextView tvN2 = new TextView(this);
        tvN2.setText("height.toSting");
        tvN2.setTextSize(textNineHeight);
        final TextView res = new TextView(this);
        res.setText("23439789789799789453455");
        res.setTextSize(18 * textNineHeight/10);
        // Creating a new Left Button
        bt1 = new Button(this);
        bt1.setText("1");
        bt1.setWidth(forthWidth);bt1.setHeight(nineHeight);
        bt1.setTextSize(textButtonSize);
         bt2 = new Button(this);
        bt2.setText("2");
        bt2.setWidth(forthWidth);bt2.setHeight(nineHeight);
        bt2.setTextSize(textButtonSize);
        bt3 = new Button(this);
        bt3.setText("3");
        bt3.setWidth(forthWidth);bt3.setHeight(nineHeight);
        bt3.setTextSize(textButtonSize);
        bt4 = new Button(this);
        bt4.setText("4");
        bt4.setWidth(forthWidth);bt4.setHeight(nineHeight);
        bt4.setTextSize(textButtonSize);
        bt5 = new Button(this);
        bt5.setText("5");
        bt5.setWidth(forthWidth);bt5.setHeight(nineHeight);
        bt5.setTextSize(textButtonSize);
        bt6 = new Button(this);
        bt6.setText("6");
        bt6.setWidth(forthWidth);bt6.setHeight(nineHeight);
        bt6.setTextSize(textButtonSize);
        bt7 = new Button(this);
        bt7.setText("7");
        bt7.setWidth(forthWidth);bt7.setHeight(nineHeight);
        bt7.setTextSize(textButtonSize);
        bt8 = new Button(this);
        bt8.setText("8");
        bt8.setWidth(forthWidth);bt8.setHeight(nineHeight);
        bt8.setTextSize(textButtonSize);
        bt9 = new Button(this);
        bt9.setText("9");
        bt9.setWidth(forthWidth);bt9.setHeight(nineHeight);
        bt9.setTextSize(textButtonSize);
        bt0 = new Button(this);
        bt0.setText("0");
        bt0.setWidth(forthWidth);bt0.setHeight(nineHeight);
        bt0.setTextSize(textButtonSize);
        btDot = new Button(this);
        btDot.setText(".");
        btDot.setWidth(forthWidth);btDot.setHeight(nineHeight);
        btDot.setTextSize(textButtonSize);
        btEqual = new Button(this);
        btEqual.setText("=");
        btEqual.setWidth(forthWidth);btEqual.setHeight(nineHeight);
        btEqual.setTextSize(textButtonSize);
        btEqual.setTextColor(0xFFFF0000);
        btAdd = new Button(this);
        btAdd.setText("+");
        btAdd.setWidth(forthWidth);btAdd.setHeight(nineHeight);
        btAdd.setTextSize(textButtonSize);
        btSub = new Button(this);
        btSub.setText("-");
        btSub.setWidth(forthWidth);btSub.setHeight(nineHeight);
        btSub.setTextSize(textButtonSize);
        btMulti = new Button(this);
        btMulti.setText("*");
        btMulti.setWidth(forthWidth);btMulti.setHeight(nineHeight);
        btMulti.setTextSize(textButtonSize);
        btDevide = new Button(this);
        btDevide.setText("/");
        btDevide.setWidth(forthWidth);btDevide.setHeight(nineHeight);
        btDevide.setTextSize(textButtonSize);
        btPow = new Button(this);
        btPow.setText("^");
        btPow.setWidth(forthWidth);btPow.setHeight(nineHeight);
        btPow.setTextSize(textButtonSize);
        btSqrt = new Button(this);
        btSqrt.setText("Sqrt");
        btSqrt.setWidth(forthWidth);btSqrt.setHeight(nineHeight);
        btClear = new Button(this);
        btClear.setText("C");
        btClear.setWidth(forthWidth);btClear.setHeight(nineHeight);
        btClear.setTextSize(textButtonSize);
        btClear.setTextColor(0xFF0000FF);
        btBack = new Button(this);
        btBack.setText("Back");
        btBack.setWidth(forthWidth);btBack.setHeight(nineHeight);
        btMS = new Button(this);
        btMS.setText("MS");
        btMS.setWidth(forthWidth);btMS.setHeight(nineHeight);
        btMR = new Button(this);
        btMR.setText("MR");
        btMR.setWidth(forthWidth);btMR.setHeight(nineHeight);
        btMC = new Button(this);
        btMC.setText("MC");
        btMC.setWidth(forthWidth);btMC.setHeight(nineHeight);
        btMinus = new Button(this);
        btMinus.setText("-+");
        btMinus.setWidth(forthWidth);btMinus.setHeight(nineHeight);
        btMinus.setTextSize(textButtonSize);

        // Add a Layout to the Buttons
        LayoutAddTextView(tvMemory, RelativeLayout.ALIGN_PARENT_LEFT, 0, 0, 0, 0);
        LayoutAddTextView(mem, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth / 4, 0, 0, 0);
        LayoutAddTextView(tvN1, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth / 6, twoNineHeight / 7, 0, 0);
        LayoutAddTextView(tvOpt, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight * 2 / 7, 0, 0);
        LayoutAddTextView(tvN2, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth/6, twoNineHeight*2/7, 0, 0);
        LayoutAddTextView(res, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight*3/7, 0, 0);
        int abtMS[]={0, twoNineHeight , 0, 0};
        int abtMC[]={forthWidth, twoNineHeight , 0, 0 };
        int abtMR[]={forthWidth* 2, twoNineHeight , 0, 0 };
        int abtBack[]={  3 * forthWidth, twoNineHeight, 0, 0};
        int abt1[]={0, twoNineHeight + nineHeight, 0, 0 };
        int abt2[]={forthWidth, twoNineHeight+ nineHeight, 0, 0 };
        int abt3[]={forthWidth* 2, twoNineHeight +nineHeight, 0, 0 };
        int abtClear[]={3*forthWidth, twoNineHeight  +nineHeight, 0, 0 };
        int abt4[]={0, twoNineHeight  +2*nineHeight, 0, 0 };
        int abt5[]={ forthWidth, twoNineHeight +2*nineHeight, 0, 0};
        int abt6[]={forthWidth* 2, twoNineHeight  +2*nineHeight, 0, 0 };
        int abtAdd[]={3*forthWidth, twoNineHeight  +2*nineHeight, 0, 0 };
        int abt7[]={0, twoNineHeight  +3*nineHeight, 0, 0 };
        int abt8[]={ forthWidth, twoNineHeight+ 3 * nineHeight, 0, 0};
        int abt9[]={forthWidth* 2, twoNineHeight + 3 * nineHeight, 0, 0 };
        int abtSub[]={3 * forthWidth, twoNineHeight + 3 * nineHeight, 0, 0 };
        int abtDot[]={0, twoNineHeight +4*nineHeight, 0, 0 };
        int abt0[]={forthWidth, twoNineHeight + 4 * nineHeight, 0, 0 };
        int abtEqual[]={forthWidth * 2, twoNineHeight + 4 * nineHeight, 0, 0 };
        int abtMulti[]={3 * forthWidth, twoNineHeight+ 4 * nineHeight, 0, 0 };
        int abtPow[]={ 0, twoNineHeight+5*nineHeight, 0, 0 };
        int abtSqrt[]={forthWidth, twoNineHeight+ 5 * nineHeight, 0, 0 };
        int abtMinus[]={forthWidth* 2, twoNineHeight + 5 * nineHeight, 0, 0 };
        int abtDevide[]={ 3 * forthWidth, twoNineHeight + 5 * nineHeight, 0, 0 };

        LayoutAddButton(btMS, RelativeLayout.ALIGN_PARENT_LEFT, abtMS);
        LayoutAddButton(btMC, RelativeLayout.ALIGN_PARENT_LEFT, abtMC);
        LayoutAddButton(btMR, RelativeLayout.ALIGN_PARENT_LEFT, abtMR);
        LayoutAddButton(btBack, RelativeLayout.ALIGN_PARENT_LEFT, abtBack);
        LayoutAddButton(bt1, RelativeLayout.ALIGN_PARENT_LEFT, abt1);
        LayoutAddButton(bt2, RelativeLayout.ALIGN_PARENT_LEFT, abt2);
        LayoutAddButton(bt3, RelativeLayout.ALIGN_PARENT_LEFT, abt3);
        LayoutAddButton(btClear, RelativeLayout.ALIGN_PARENT_LEFT,abtClear);
        LayoutAddButton(bt4, RelativeLayout.ALIGN_PARENT_LEFT, abt4);
        LayoutAddButton(bt5, RelativeLayout.ALIGN_PARENT_LEFT, abt5);
        LayoutAddButton(bt6, RelativeLayout.ALIGN_PARENT_LEFT, abt6);
        LayoutAddButton(btAdd, RelativeLayout.ALIGN_PARENT_LEFT,abtAdd);
        LayoutAddButton(bt7, RelativeLayout.ALIGN_PARENT_LEFT, abt7);
        LayoutAddButton(bt8, RelativeLayout.ALIGN_PARENT_LEFT, abt8);
        LayoutAddButton(bt9, RelativeLayout.ALIGN_PARENT_LEFT, abt9);
        LayoutAddButton(btSub, RelativeLayout.ALIGN_PARENT_LEFT, abtSub);
        LayoutAddButton(btDot, RelativeLayout.ALIGN_PARENT_LEFT, abtDot);
        LayoutAddButton(bt0, RelativeLayout.ALIGN_PARENT_LEFT, abt0);
        LayoutAddButton(btEqual, RelativeLayout.ALIGN_PARENT_LEFT, abtEqual);
        LayoutAddButton(btMulti, RelativeLayout.ALIGN_PARENT_LEFT, abtMulti);
        LayoutAddButton(btPow, RelativeLayout.ALIGN_PARENT_LEFT, abtPow);
        LayoutAddButton(btSqrt, RelativeLayout.ALIGN_PARENT_LEFT, abtSqrt);
        LayoutAddButton(btMinus, RelativeLayout.ALIGN_PARENT_LEFT, abtMinus);
        LayoutAddButton(btDevide, RelativeLayout.ALIGN_PARENT_LEFT, abtDevide);

     /*   LayoutAddButton(btMS, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                , 0, 0);
        LayoutAddButton(btMC, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                , 0, 0);
        LayoutAddButton(btMR, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth* 2, twoNineHeight
                , 0, 0);
        LayoutAddButton(btBack, RelativeLayout.ALIGN_PARENT_LEFT, 3 * forthWidth, twoNineHeight
                , 0, 0);
        LayoutAddButton(bt1, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                + nineHeight, 0, 0);
        LayoutAddButton(bt2, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                + nineHeight, 0, 0);
        LayoutAddButton(bt3, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth* 2, twoNineHeight
                +nineHeight, 0, 0);
        LayoutAddButton(btClear, RelativeLayout.ALIGN_PARENT_LEFT,3*forthWidth, twoNineHeight
                +nineHeight, 0, 0);
        LayoutAddButton(bt4, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                +2*nineHeight, 0, 0);
        LayoutAddButton(bt5, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                +2*nineHeight, 0, 0);
        LayoutAddButton(bt6, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth* 2, twoNineHeight
                +2*nineHeight, 0, 0);
        LayoutAddButton(btAdd, RelativeLayout.ALIGN_PARENT_LEFT,3*forthWidth, twoNineHeight
                +2*nineHeight, 0, 0);
        LayoutAddButton(bt7, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                +3*nineHeight, 0, 0);
        LayoutAddButton(bt8, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                + 3 * nineHeight, 0, 0);
        LayoutAddButton(bt9, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth* 2, twoNineHeight
                + 3 * nineHeight, 0, 0);
        LayoutAddButton(btSub, RelativeLayout.ALIGN_PARENT_LEFT, 3 * forthWidth, twoNineHeight
                + 3 * nineHeight, 0, 0);
        LayoutAddButton(btDot, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                +4*nineHeight, 0, 0);
        LayoutAddButton(bt0, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                + 4 * nineHeight, 0, 0);
        LayoutAddButton(btEqual, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth * 2, twoNineHeight
                + 4 * nineHeight, 0, 0);
        LayoutAddButton(btMulti, RelativeLayout.ALIGN_PARENT_LEFT, 3 * forthWidth, twoNineHeight
                + 4 * nineHeight, 0, 0);
        LayoutAddButton(btPow, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight
                +5*nineHeight, 0, 0);
        LayoutAddButton(btSqrt, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth, twoNineHeight
                + 5 * nineHeight, 0, 0);
        LayoutAddButton(btMinus, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth* 2, twoNineHeight
                + 5 * nineHeight, 0, 0);
        LayoutAddButton(btDevide, RelativeLayout.ALIGN_PARENT_LEFT, 3 * forthWidth, twoNineHeight
                + 5 * nineHeight, 0, 0);*/




        // Add the Buttons to the View
        relativeLayout.addView(bt1);
        relativeLayout.addView(bt2);
        relativeLayout.addView(bt3);
        relativeLayout.addView(bt4);
        relativeLayout.addView(bt5);
        relativeLayout.addView(bt6);
        relativeLayout.addView(bt7);
        relativeLayout.addView(bt8);
        relativeLayout.addView(bt9);
        relativeLayout.addView(btMC);
        relativeLayout.addView(btMS);
        relativeLayout.addView(btMR);
        relativeLayout.addView(btMinus);
        relativeLayout.addView(btAdd);
        relativeLayout.addView(btSub);
        relativeLayout.addView(btMulti);
        relativeLayout.addView(btDevide);
        relativeLayout.addView(btDot);
        relativeLayout.addView(bt0);
        relativeLayout.addView(btEqual);
        relativeLayout.addView(btPow);
        relativeLayout.addView(btSqrt);
        relativeLayout.addView(btClear);
        relativeLayout.addView(btBack);
        relativeLayout.addView(tvMemory);
        relativeLayout.addView(mem);
        relativeLayout.addView(tvN1);
        relativeLayout.addView(tvOpt);
        relativeLayout.addView(tvN2);
        relativeLayout.addView(res);

        // Setting the RelativeLayout as our content view
        setContentView(relativeLayout, relativeLayoutParams);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @Override
            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */


                res.setText(count + "");

                // restt.setTextColor(0xFFF06D2F);
                Random rand = new Random();
                ;
                //tvN1.setText(bb+"");
               /* tvN2.setText(bt7.getLeft()+"");
                mem.setText(bt9.getX()+"");
                int p= bt2.getBottom();
               bt2.setX(bt8.getX());
                bt2.setY(bt8.getY());
                bt1.setBottom(p);*/

                //The random generator creates values between [0,256) for use as RGB values used below to create a random color
                //We call the RelativeLayout object and we change the color.  The first parameter in argb() is the alpha.

                res.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                handleShakeEvent(count);
                bt1.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt2.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt3.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt4.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt5.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt6.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt7.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt8.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt9.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                bt0.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btDot.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btEqual.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btAdd.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btSub.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btMulti.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btDevide.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btSqrt.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btPow.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btMinus.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btClear.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btBack.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btMC.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btMS.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
                btMR.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

            }

            private void handleShakeEvent(int count) {
                shake = count;
            }
        });





        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                if (progress)
                    res.setText(res.getText()+"1");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"1");progress=true;}
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"2");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"2");progress=true;}
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"3");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"3");progress=true;}
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"4");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"4");progress=true;}
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"5");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"5");progress=true;}
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"6");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"6");progress=true;}
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"7");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"7");progress=true;}
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"8");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"8");progress=true;}
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"9");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"9");progress=true;}
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress)
                    res.setText(res.getText()+"0");
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"0");progress=true;}
            }
        });
        btDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    if(res.getText().toString().length() == 0){
                        res.setText(res.getText() + "0.");}
                    else if(!res.getText().toString().contains(".")) {
                        res.setText(res.getText() + ".");
                    }}
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText() + "0.");progress=true;

                }

                //
            }
        });
        btClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");progress=true; operator=' ';
            }
        });
        btBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                res.setText(TruncatLast.truncat(res.getText().toString()));

            }
        });
        btAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {

                operatorSign= btAdd.getText().charAt(0);
                if(operator==' '){

                    tvOpt.setText(operator.toString());

                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("+"+ " ");tvN1.setText(num1.toString());
                    operator='+';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='+') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=num1+num2;

                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");
                        progress=true;}

                }
                else {
                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("+"+ " ");tvN1.setText(num1.toString());
                            operator='+';
                            progress=true;
                            tvN2.setText("");
                        }

                        try {


                            num2 = Double.parseDouble(res.getText().toString());



                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }
                        Double resssult=operation();
                        num1=resssult;
                        tvN1.setText(resssult.toString());
                        tvN2.setText("");
                        tvOpt.setText("+"+ " ");
                        res.setText("");
                        operator='+';}

                }}

        });
        btSub.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator==' '){
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("-"+ " ");tvN1.setText(num1.toString());
                    operator='-';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='-') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=num1-num2;
                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");}

                }
                else {

                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("-"+ " ");tvN1.setText(num1.toString());
                            operator='-';
                            progress=true;
                            tvN2.setText("");
                        }else{
                            try {


                                num2 = Double.parseDouble(res.getText().toString());



                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation();
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("-"+ " ");
                            res.setText("");
                            operator='-';}

                    }}
            }
        });
        btMulti.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator==' '){
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("*"+ " ");tvN1.setText(num1.toString());
                    operator='*';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='*') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=num1*num2;
                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");}

                }
                else {

                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("*"+ " ");tvN1.setText(num1.toString());
                            operator='*';
                            progress=true;
                            tvN2.setText("");
                        }

                        else{
                            try {


                                num2 = Double.parseDouble(res.getText().toString());



                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation();
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("*"+ " ");
                            res.setText("");
                            operator='*';}

                    }}
            }
        });
        btDevide.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator==' '){
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("/"+ " ");tvN1.setText(num1.toString());
                    operator='/';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='/') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=num1/num2;
                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");}

                }
                else {

                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("/"+ " ");tvN1.setText(num1.toString());
                            operator='/';
                            progress=true;
                            tvN2.setText("");
                        }

                        else{
                            try {


                                num2 = Double.parseDouble(res.getText().toString());



                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation();
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("/"+ " ");
                            res.setText("");
                            operator='/';}

                    }}
            }
        });
        btPow.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator==' '){
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("^"+ " ");tvN1.setText(num1.toString());
                    operator='^';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='^') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=Math.pow(num1, num2);
                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");}

                }
                else {

                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("^"+ " ");tvN1.setText(num1.toString());
                            operator='^';
                            progress=true;
                            tvN2.setText("");
                        }

                        else{
                            try {


                                num2 = Double.parseDouble(res.getText().toString());



                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation();
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("^"+ " ");
                            res.setText("");
                            operator='^';}

                    }}
            }

        });
        btSqrt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(operator==' '){
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("Sqrt"+ " ");tvN1.setText(num1.toString());
                    operator='s';
                    progress=true;
                    tvN2.setText("");}
                else if(operator=='s') {
                    tvOpt.setText(operator.toString()+" ");
                    if (progress){
                        try {
                            num2 = Double.parseDouble(res.getText().toString());
                            num1=Math.pow(num1,(1/num2));
                        }catch(Exception e){
                            System.out.print("Wrong button pressed");
                        }

                        tvN1.setText(num1.toString());
                        tvN2.setText(num2.toString());
                        res.setText("");}

                }
                else {

                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(operator.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("Sqrt"+ " ");tvN1.setText(num1.toString());
                            operator='s';
                            progress=true;
                            tvN2.setText("");
                        }

                        else{
                            try {


                                num2 = Double.parseDouble(res.getText().toString());



                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation();
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("Sqrt"+ " ");
                            res.setText("");
                            operator='s';}

                    }}

            }
        });
        btEqual.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    num2 = Double.parseDouble(res.getText().toString());
                }catch(Exception e){
                    System.out.print("Wrong button pressed");
                }  if (progress){res.setText("");}
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '^':
                        result= Math.pow(num1, num2);
                        break;
                    case 's':
                        result= Math.pow(num1,(1/num2));
                        break;
                    case ' ':
                        break;

                };
                if(res.getText().length()==0&&tvN1.getText().length()==0&&tvN2.getText().length()==0){System.out.print("Wrong button pressed");}
                else if (progress){
                    res.setText(result.toString());tvN2.setText(num2.toString());
                    num1=0.0;
                    num2=0.0;
                    result=0.0;
                    operator=' ';
                    progress=false;}
            }
        });
        btMS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(res.getText().length()!=0){
                    memory= Double.parseDouble(res.getText().toString());
                    mem.setText(memory.toString());}
            }
        });
        btMR.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                res.setText(memory.toString());
            }
        });
        btMC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                memory=0.0;
                mem.setText(memory.toString());
            }

        });
        btMinus.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


                if((res.getText().toString().length() != 0)&& Double.parseDouble(res.getText().toString()) !=0.0) {
                    minus = -1.0*Double.parseDouble(res.getText().toString());
                    res.setText( minus.toString());
                }

                //
            }
        });
    }




    public double operation() {
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '^':
                result = Math.pow(num1, num2);
                break;
            case 's':
                result = Math.pow(num1, (1 / num2));
                break;
            case ' ':
                break;


        }
        return result;
    }
    public void setPositions(){
        ArrayList<Integer> arrPosition=new ArrayList<>();

    }

public void getPositions(){
  /*  LayoutAddButton(btMS, RelativeLayout.ALIGN_PARENT_LEFT, abtMS);
    LayoutAddButton(btMC, RelativeLayout.ALIGN_PARENT_LEFT, abtMC);
    LayoutAddButton(btMR, RelativeLayout.ALIGN_PARENT_LEFT, abtMR);
    LayoutAddButton(btBack, RelativeLayout.ALIGN_PARENT_LEFT, abtBack);
    LayoutAddButton(bt1, RelativeLayout.ALIGN_PARENT_LEFT, abt1);
    LayoutAddButton(bt2, RelativeLayout.ALIGN_PARENT_LEFT, abt2);
    LayoutAddButton(bt3, RelativeLayout.ALIGN_PARENT_LEFT, abt3);
    LayoutAddButton(btClear, RelativeLayout.ALIGN_PARENT_LEFT,abtClear);
    LayoutAddButton(bt4, RelativeLayout.ALIGN_PARENT_LEFT, abt4);
    LayoutAddButton(bt5, RelativeLayout.ALIGN_PARENT_LEFT, abt5);
    LayoutAddButton(bt6, RelativeLayout.ALIGN_PARENT_LEFT, abt6);
    LayoutAddButton(btAdd, RelativeLayout.ALIGN_PARENT_LEFT,abtAdd);
    LayoutAddButton(bt7, RelativeLayout.ALIGN_PARENT_LEFT, abt7);
    LayoutAddButton(bt8, RelativeLayout.ALIGN_PARENT_LEFT, abt8);
    LayoutAddButton(bt9, RelativeLayout.ALIGN_PARENT_LEFT, abt9);
    LayoutAddButton(btSub, RelativeLayout.ALIGN_PARENT_LEFT, abtSub);
    LayoutAddButton(btDot, RelativeLayout.ALIGN_PARENT_LEFT, abtDot);
    LayoutAddButton(bt0, RelativeLayout.ALIGN_PARENT_LEFT, abt0);
    LayoutAddButton(btEqual, RelativeLayout.ALIGN_PARENT_LEFT, abtEqual);
    LayoutAddButton(btMulti, RelativeLayout.ALIGN_PARENT_LEFT, abtMulti);
    LayoutAddButton(btPow, RelativeLayout.ALIGN_PARENT_LEFT, abtPow);
    LayoutAddButton(btSqrt, RelativeLayout.ALIGN_PARENT_LEFT, abtSqrt);
    LayoutAddButton(btMinus, RelativeLayout.ALIGN_PARENT_LEFT, abtMinus);
    LayoutAddButton(btDevide, RelativeLayout.ALIGN_PARENT_LEFT, abtDevide);*/

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    private void LayoutAddButton(Button button, int centerInParent,int arrayPosition[] ) {
        // Defining the layout parameters of the Button
        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        int marginLeft= arrayPosition[0];
        int marginTop= arrayPosition[1];
        int marginRight= arrayPosition[2];
        int marginBottom= arrayPosition[3];
        // Add Margin to the LayoutParameters
        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);

        // Add Rule to Layout
        buttonLayoutParameters.addRule(centerInParent);

        // Setting the parameters on the Button
        button.setLayoutParams(buttonLayoutParameters);
    }

   /* private void AddButtonLayout(Button button, int centerInParent) {
        // Just call the other AddButtonLayout Method with Margin 0
       // int arrayPosition[]={0,0,0,0};
        LayoutAddButton(button, centerInParent, 0,0,0,0);
    }*/
    private void LayoutAddTextView(TextView tv, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        // Defining the layout parameters of the Button
        RelativeLayout.LayoutParams tvLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Add Margin to the LayoutParameters
        tvLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);

        // Add Rule to Layout
        tvLayoutParameters.addRule(centerInParent);

        // Setting the parameters on the Button
        tv.setLayoutParams(tvLayoutParameters);
    }

    private void AddTextViewLayout(TextView tv, int centerInParent) {
        // Just call the other AddTextViewLayout Method with Margin 0
        LayoutAddTextView(tv, centerInParent, 0, 0, 0, 0);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
