package com.kpr.hus.dynamicbutton;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Double num1=0.0;
    Double num2=0.0;
    Double result= 0.0;
    Double memory=0.0;
    Double minus = 0.0;
    Character operator = ' ';
    Character operatorSign=' ';
    //HashMap<Integer,ArrayList<Integer>> position= new HashMap<Integer,ArrayList<Integer>>();
    Integer abtMS[]={0,0};
    //Integer abtMC[]={0,0};
    Integer atoggle[]={0,0};
    Integer abtMR[]={0,0};
    Integer abtBack[]={0,0};
    Integer abt1[]={0,0};
    Integer abt2[]={0,0};
    Integer abt3[]={0,0};
    Integer abtClear[]={0,0};
    Integer abt4[]={0,0};
    Integer abt5[]={0,0};
    Integer abt6[]={0,0};
    Integer abtAdd[]={0,0};
    Integer abt7[]={0,0};
    Integer abt8[]={0,0};
    Integer abt9[]={0,0};
    Integer abtSub[]={0,0};
    Integer abtDot[]={0,0};
    Integer abt0[]={0,0};
    Integer abtEqual[]={0,0};
    Integer abtMulti[]={0,0};
    Integer abtPow[]={0,0};
    Integer abtSqrt[]={0,0};
    Integer abtMinus[]={0,0};
    Integer abtDevide[]={0,0};
    int alpha = 155;
    int shake=0;
    float pixels;

    int nineHeight;
    int twoNineHeight;
    int textNineHeight;
    int textButtonSize;
    int forthWidth;

    boolean progress= true;
    boolean crazy= false;
    boolean superCrazy= false;


    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    private InterstitialAd mInterstitialAd;
    private static final String TAG = "MainActivity";

    Button btMS,btMC,btMR,btBack,bt1,bt2, bt3,btClear,bt4,bt5,bt6,btAdd,bt7, bt8, bt9, btSub,btDot,bt0,btEqual,btMulti,btPow, btSqrt,btMinus,btDevide;
    ToggleButton toggle;
    TextView res;
    TextView mem;
    TextView tvN1;
    TextView tvN2;
    double width;
    int maximumResLength =20;
    int maximumResLength16 =50;
    public void widthHeight(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 13, getResources().getDisplayMetrics());

// this code is for Interstitial ads
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH")
                .build();

        mInterstitialAd.loadAd(adRequest);

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }

        // this code is for banner advertise
     /*   AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice("YOUR_DEVICE_HASH")
                .build();
        mAdView.loadAd(adRequest2);*/

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
        nineHeight=height/10;
        twoNineHeight= nineHeight  * 18/10;
        textNineHeight= nineHeight/12;
        textButtonSize= nineHeight/5;
        forthWidth = (int)width / 4;
        if (height<1300){
            textNineHeight= nineHeight/6;
           // textButtonSize= nineHeight/2;
        }
        double ratio= (height/width );
        /*int size = getResources().getConfiguration().screenLayout;

        if ((size & Configuration.SCREENLAYOUT_SIZE_XLARGE)==Configuration.SCREENLAYOUT_SIZE_XLARGE){
            textNineHeight= nineHeight/6;
        }*/
        //float HEIGHT2=textNineHeight;
        // int height33 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, HEIGHT2, getResources().getDisplayMetrics());

        //You can set the <HEIGHT> anything which is appropriate for you for testing. EX:
       // textView.setTextSize(height);


        // Creating a new RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);

        // Defining the RelativeLayout layout parameters with Fill_Parent
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);



        final TextView tvMemory = new TextView(this);
        tvMemory.setText("M: ");
        tvMemory.setTextSize(textNineHeight);
       // Spannable span = new SpannableString("B");
        //span.setSpan(new RelativeSizeSpan(1f), 0, span.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //tvMemory.setText(span);
        mem = new TextView(this);
        mem.setText("");
       //mem.setTextSize(TypedValue.COMPLEX_UNIT_SP,textNineHeight);
        mem.setTextSize(textNineHeight);
        //mem.setTextSize(height33);
        tvN1 = new TextView(this);
        tvN1.setText("");
        tvN1.setTextSize(textNineHeight);
        final TextView tvOpt = new TextView(this);
        tvOpt.setText("");
        tvOpt.setTextSize(textNineHeight);
        tvOpt.setTextColor(0xFFF06D2F);
        tvN2 = new TextView(this);
        tvN2.setText("");
        tvN2.setTextSize(textNineHeight);
        res = new TextView(this);
        res.setText("");
       // res.setTextSize(18 * textNineHeight / 6);
        res.setTextSize(twoNineHeight * 3 / 5);
       // res.setHeight(twoNineHeight * 3 / 5);
        //mem.setText(twoNineHeight * 3 / 7+"");

        // Creating a new Left Button
        bt1 = new Button(this);
        bt1.setText("1");
        bt1.setWidth(forthWidth);
        bt1.setHeight(nineHeight);
        bt1.setTextSize(textButtonSize);
        //bt1.setTextSize(TypedValue.COMPLEX_UNIT_SP, textButtonSize);
       // Spannable span1 = new SpannableString("1");
       // span1.setSpan(new RelativeSizeSpan(5f), 0, span1.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
       // bt1.setText(span1);
        bt2 = new Button(this);
        bt2.setText("2");
        bt2.setWidth(forthWidth);bt2.setHeight(nineHeight);
        bt2.setTextSize(textButtonSize);
        bt3 = new Button(this);
        bt3.setText("3");
        bt3.setWidth(forthWidth);
        bt3.setHeight(nineHeight);
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
        bt8.setWidth(forthWidth);
        bt8.setHeight(nineHeight);
        bt8.setTextSize(textButtonSize);
        bt9 = new Button(this);
        bt9.setText("9");
        bt9.setWidth(forthWidth);
        bt9.setHeight(nineHeight);
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
       // btMC = new Button(this);
       // btMC.setText("MC");
      //  btMC.setWidth(forthWidth);btMC.setHeight(nineHeight);
        toggle = new ToggleButton(this);
        toggle.setText("Crazy");
        toggle.setWidth(forthWidth);toggle.setHeight(nineHeight);
        btMinus = new Button(this);
        btMinus.setText("-+");
        btMinus.setWidth(forthWidth);btMinus.setHeight(nineHeight);
        btMinus.setTextSize(textButtonSize);
        // this code is for banner advertise
        AdView mAdView = new AdView(this);
        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");
        mAdView.setAdSize(AdSize.SMART_BANNER);
        AdRequest adRequest2 = new AdRequest.Builder().addTestDevice("YOUR_DEVICE_HASH").build();
        LayoutAddAdView(mAdView, RelativeLayout.ALIGN_PARENT_LEFT, 0,(twoNineHeight + 6 * nineHeight)+(height/592) , 0, 0);

        try{mAdView.loadAd(adRequest2);
        }
        catch(Exception e){
            Log.v(TAG, "Error in loading ad");
        }

        // Add a Layout to the Buttons
        LayoutAddTextView(tvMemory, RelativeLayout.ALIGN_PARENT_LEFT, 0, 0, 0, 0);
        LayoutAddTextView(mem, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth / 4, 0, 0, 0);
        LayoutAddTextView(tvN1, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth / 6, twoNineHeight / 7, 0, 0);
        LayoutAddTextView(tvOpt, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight * 2 / 7, 0, 0);
        LayoutAddTextView(tvN2, RelativeLayout.ALIGN_PARENT_LEFT, forthWidth / 6, twoNineHeight * 2 / 7, 0, 0);
        LayoutAddTextView(res, RelativeLayout.ALIGN_PARENT_LEFT, 0, twoNineHeight * 3 / 7, 0, 0);

        putButtonsPositionInArray();
        buttonOriginalPosition();






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
        //relativeLayout.addView(btMC);
        relativeLayout.addView(toggle);
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
        relativeLayout.addView(mAdView);


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

                // Random rand = new Random();
                //The random generator creates values between [0,256) for use as RGB values used below to create a random color
                //We call the RelativeLayout object and we change the color.  The first parameter in argb() is the alpha.
                if (crazy && !superCrazy) {
                    buttonRandomColor(res);
                    addToResultByShake();

                } else if (superCrazy) {
                    addToResultByShake();
                    buttonRandomColor(res);
                    randomPositions();

                }
            }

           /* private void handleShakeEvent(int count) {
                shake = count;
            }*/
        });






        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "1", Toast.LENGTH_SHORT).show();
                if (progress){
                    res.setText(res.getText() + "1");
                    decreasTextViewSize(res);
                }
                else if (!progress) {
                    res.setText("");
                    tvOpt.setText("");
                    tvN1.setText("");
                    tvN2.setText("");
                    res.setText(res.getText() + "1");
                    progress = true;
                }
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"2");
                decreasTextViewSize(res);
            }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"2");progress=true;}
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"3");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"3");progress=true;}
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"4");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"4");progress=true;}
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"5");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"5");progress=true;}
            }
        });
        bt6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"6");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"6");progress=true;}
            }
        });
        bt7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"7");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"7");progress=true;}
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"8");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"8");progress=true;}
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"9");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"9");progress=true;}
            }
        });
        bt0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    res.setText(res.getText()+"0");
                    decreasTextViewSize(res);
                }
                else if (!progress)
                { res.setText("");tvOpt.setText("");tvN1.setText("");tvN2.setText("");res.setText(res.getText()+"0");progress=true;}
            }
        });
        btDot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (progress){
                    if(res.getText().toString().length() == 0){
                        res.setText(res.getText() + "0.");
                        decreasTextViewSize(res);
                    }
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
                decreasTextViewSize(res);

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
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
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
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                            eliminateDotAndZero(tvN1);
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
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                            eliminateDotAndZero(tvN1);
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
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                            eliminateDotAndZero(tvN1);
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
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                            eliminateDotAndZero(tvN1);
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
                    res.setText("");tvOpt.setText("S"+ " ");tvN1.setText(num1.toString());
                    eliminateDotAndZero(tvN1);
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
                        eliminateDotAndZero(tvN1);
                        tvN2.setText(num2.toString());
                        eliminateDotAndZero(tvN2);
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
                            eliminateDotAndZero(tvN1);
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
                            eliminateDotAndZero(tvN1);
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
                    eliminateDotAndZero(tvN2);
                    num1=0.0;
                    num2=0.0;
                    result=0.0;
                    operator=' ';
                    progress=false;
                }
                eliminateDotAndZero(res);
                decreasTextViewSize(res);


              /*  Paint paint = new Paint();
                Rect bounds = new Rect();
                int text_height = 0;
                int text_width = 0;
                String text = res.getText().toString();
                paint.getTextBounds(text, 0, text.length(), bounds);
                text_height =  bounds.height();
                text_width =  bounds.width();
               tvN1.setText(text_height+"");
               tvN2.setText(text_width+"");*/
            }

        });
        btMS.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(res.getText().length()!=0){
                    memory= Double.parseDouble(res.getText().toString());
                    mem.setText(memory.toString());
                    eliminateDotAndZero(mem);
                }
            }
        });
        btMR.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                res.setText(memory.toString());
                eliminateDotAndZero(res);
                decreasTextViewSize(res);
            }
        });
        /*btMC.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                memory=0.0;
                mem.setText(memory.toString());
            }

        });*/
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Crazy is on. Shake the device.", Toast.LENGTH_SHORT).show();
                    crazy=true;
                    superCrazy=true;
                    toggle.setTextOn("Crazy");
                    buttonRandomColor(res);
                    randomPositions();
                } else {
                    crazy=false;
                    superCrazy=false;
                    buttonOriginalPosition();
                    buttonNormalColor(res);
                    toggle.setTextOff("Normal");
                    Toast.makeText(getApplicationContext(), "Crazy is off.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                if ((res.getText().toString().length() != 0) && Double.parseDouble(res.getText().toString()) != 0.0) {
                    minus = -1.0 * Double.parseDouble(res.getText().toString());
                    res.setText(minus.toString());
                    eliminateDotAndZero(res);
                }

                //
            }
        });
        buttonNormalColor(res);

        // End of create method.
    }

    private void addToResultByShake() {
        Double ressult=0.0;
        if(res.getText().length()>0){
        ressult=Double.parseDouble(res.getText().toString());
        }
        ressult++;
        res.setText("" + ressult);
        eliminateDotAndZero(res);
    }
    private int isTooLarge (TextView text, String newText) {
        int i=0;

        //float textWidth = text.getPaint().measureText(newText);

       if(text.getText().length()==2){
         i= text.getMeasuredWidth();
          maximumResLength =(int)(width/i);
           maximumResLength16=(maximumResLength*50)/15;
        }


       return maximumResLength;


    }
public void decreasTextViewSize(TextView ress){
    int  length= isTooLarge (ress, ress.getText().toString());
    if(ress.getText().length()<length){
        ress.setTextSize(18 * textNineHeight / 6);
    }
    if(ress.getText().length()>length&& ress.getText().length()<maximumResLength16){
        ress.setTextSize(18 * textNineHeight / 10);
    }
    if(ress.getText().length()>maximumResLength16){
        ress.setTextSize(18 * textNineHeight / 18);
    }




}
    private void buttonRandomColor(TextView res) {
        Random rand = new Random();
        res.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
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
        //btMC.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        toggle.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        btMS.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        btMR.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
    }
    private void buttonNormalColor(TextView res) {
        res.setBackgroundColor(Color.argb(0, 0, 0, 0));
        bt1.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt2.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt3.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt4.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt5.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt6.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt7.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt8.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt9.setBackgroundColor(Color.argb(55, 0, 0, 0));
        bt0.setBackgroundColor(Color.argb(55, 0, 0, 0));
        btDot.setBackgroundColor(Color.argb(55, 0, 0, 55));
        btEqual.setBackgroundColor(Color.argb(55, 0, 0, 55));
        btAdd.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btSub.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btMulti.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btDevide.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btSqrt.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btPow.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btMinus.setBackgroundColor(Color.argb(55, 55, 0, 0));
        btClear.setBackgroundColor(Color.argb(55, 0, 50, 50));
        btBack.setBackgroundColor(Color.argb(55, 0, 50, 50));
        //btMC.setBackgroundColor(Color.argb(alpha, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        toggle.setBackgroundColor(Color.argb(55, 255, 0, 0));
        btMS.setBackgroundColor(Color.argb(55, 0, 0, 55));
        btMR.setBackgroundColor(Color.argb(55, 0, 0, 55));
    }
    private void putButtonsPositionInArray() {
        abtMS[0]=0;
        abtMS[1]=twoNineHeight;
        //abtMC[0]=forthWidth;
       // abtMC[1]= twoNineHeight;
        atoggle[0]=forthWidth;
        atoggle[1]= twoNineHeight;
        abtMR[0]=forthWidth* 2;
        abtMR[1]=twoNineHeight;
        abtBack[0]= 3 * forthWidth;
        abtBack[1]= twoNineHeight;
        abt1[0]=0;
        abt1[1]= twoNineHeight + nineHeight;
        abt2[0]=forthWidth;
        abt2[1]= twoNineHeight+ nineHeight;
        abt3[0]=forthWidth* 2;
        abt3[1]=twoNineHeight +nineHeight;
        abtClear[0]=3*forthWidth;
        abtClear[1]=twoNineHeight  +nineHeight;
        abt4[0]=0;
        abt4[1]= twoNineHeight  +2*nineHeight;
        abt5[0]= forthWidth;
        abt5[1]= twoNineHeight +2*nineHeight;
        abt6[0]=forthWidth* 2;
        abt6[1]= twoNineHeight  +2*nineHeight;
        abtAdd[0]=3*forthWidth;
        abtAdd[1]= twoNineHeight  +2*nineHeight ;
        abt7[0]=0;
        abt7[1]= twoNineHeight  +3*nineHeight;
        abt8[0]= forthWidth;
        abt8[1]=twoNineHeight+ 3 * nineHeight;
        abt9[0]=forthWidth* 2;
        abt9[1]= twoNineHeight + 3 * nineHeight;
        abtSub[0]=3 * forthWidth;
        abtSub[1]= twoNineHeight + 3 * nineHeight;
        abtDot[0]=0;
        abtDot[1]=twoNineHeight +4*nineHeight;
        abt0[0]=forthWidth;
        abt0[1]= twoNineHeight + 4 * nineHeight;
        abtEqual[0]=forthWidth * 2;
        abtEqual[1]= twoNineHeight + 4 * nineHeight;
        abtMulti[0]=3 * forthWidth;
        abtMulti[1]= twoNineHeight+ 4 * nineHeight;
        abtPow[0]= 0;
        abtPow[1]= twoNineHeight+5*nineHeight;
        abtSqrt[0]=forthWidth;
        abtSqrt[1]= twoNineHeight+ 5 * nineHeight;
        abtMinus[0]=forthWidth* 2;
        abtMinus[1]= twoNineHeight + 5 * nineHeight;
        abtDevide[0]= 3 * forthWidth;
        abtDevide[1]=twoNineHeight + 5 * nineHeight;
    }




public void buttonOriginalPosition(){
    LayoutAddButton(btMS, RelativeLayout.ALIGN_PARENT_LEFT, abtMS);
   // LayoutAddButton(btMC, RelativeLayout.ALIGN_PARENT_LEFT, abtMC);
    LayoutAddButton(toggle, RelativeLayout.ALIGN_PARENT_LEFT, atoggle);
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

}
    public void randomPositions(){

        final List<Integer[]> x = new ArrayList<>();
        x.add(abtMS);
       // x.add(abtMC);
        x.add(atoggle);
        x.add(abtMR);
        x.add(abtBack);
        x.add(abt1);
        x.add(abt2);
        x.add(abt3);
        x.add(abtClear);
        x.add(abt4);
        x.add(abt5);
        x.add(abt6);
        x.add(abtAdd);
        x.add(abt7);
        x.add(abt8);
        x.add(abt9);
        x.add(abtSub);
        x.add(abtDot);
        x.add(abt0);
        x.add(abtEqual);
        x.add(abtMulti);
        x.add(abtPow);
        x.add(abtSqrt);
        x.add(abtMinus);
        x.add(abtDevide);

        Collections.shuffle(x);



        LayoutAddButton(btMS, RelativeLayout.ALIGN_PARENT_LEFT, x.get(0));
        //LayoutAddButton(btMC, RelativeLayout.ALIGN_PARENT_LEFT, x.get(1));
        LayoutAddButton(toggle, RelativeLayout.ALIGN_PARENT_LEFT, x.get(1));
        LayoutAddButton(btMR, RelativeLayout.ALIGN_PARENT_LEFT, x.get(2));
        LayoutAddButton(btBack, RelativeLayout.ALIGN_PARENT_LEFT, x.get(3));
        LayoutAddButton(bt1, RelativeLayout.ALIGN_PARENT_LEFT, x.get(4));
        LayoutAddButton(bt2, RelativeLayout.ALIGN_PARENT_LEFT, x.get(5));
        LayoutAddButton(bt3, RelativeLayout.ALIGN_PARENT_LEFT, x.get(6));
        LayoutAddButton(btClear, RelativeLayout.ALIGN_PARENT_LEFT,x.get(7));
        LayoutAddButton(bt4, RelativeLayout.ALIGN_PARENT_LEFT, x.get(8));
        LayoutAddButton(bt5, RelativeLayout.ALIGN_PARENT_LEFT, x.get(9));
        LayoutAddButton(bt6, RelativeLayout.ALIGN_PARENT_LEFT, x.get(10));
        LayoutAddButton(btAdd, RelativeLayout.ALIGN_PARENT_LEFT,x.get(11));
        LayoutAddButton(bt7, RelativeLayout.ALIGN_PARENT_LEFT, x.get(12));
        LayoutAddButton(bt8, RelativeLayout.ALIGN_PARENT_LEFT, x.get(13));
        LayoutAddButton(bt9, RelativeLayout.ALIGN_PARENT_LEFT, x.get(14));
        LayoutAddButton(btSub, RelativeLayout.ALIGN_PARENT_LEFT, x.get(15));
        LayoutAddButton(btDot, RelativeLayout.ALIGN_PARENT_LEFT, x.get(16));
        LayoutAddButton(bt0, RelativeLayout.ALIGN_PARENT_LEFT, x.get(17));
        LayoutAddButton(btEqual, RelativeLayout.ALIGN_PARENT_LEFT, x.get(18));
        LayoutAddButton(btMulti, RelativeLayout.ALIGN_PARENT_LEFT, x.get(19));
        LayoutAddButton(btPow, RelativeLayout.ALIGN_PARENT_LEFT, x.get(20));
        LayoutAddButton(btSqrt, RelativeLayout.ALIGN_PARENT_LEFT, x.get(21));
        LayoutAddButton(btMinus, RelativeLayout.ALIGN_PARENT_LEFT, x.get(22));
        LayoutAddButton(btDevide, RelativeLayout.ALIGN_PARENT_LEFT, x.get(23));
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

    private void LayoutAddButton(Button button, int centerInParent,Integer arrayPosition[] ) {
        // Defining the layout parameters of the Button
        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        int marginLeft= arrayPosition[0];
        int marginTop= arrayPosition[1];

        // Add Margin to the LayoutParameters
        buttonLayoutParameters.setMargins(marginLeft, marginTop, 0, 0);

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

    private void LayoutAddAdView(AdView adV, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom) {
        // Defining the layout parameters of the AdView
        RelativeLayout.LayoutParams tvLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        // Add Margin to the LayoutParameters
        tvLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);

        // Add Rule to Layout
        tvLayoutParameters.addRule(centerInParent);

        // Setting the parameters on the AdView
        adV.setLayoutParams(tvLayoutParameters);
    }
public void eliminateDotAndZero(TextView resss){
    if(resss.getText().length()>0){
    if((resss.getText().charAt(resss.getText().length()-1))=='0'&& (resss.getText().charAt(resss.getText().length()-2))=='.'){
        resss.setText(resss.getText().toString().substring(0, resss.getText().length() - 2));
    }}
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            Intent settingIntent = new Intent(getApplicationContext(),Setting.class);
            startActivity(settingIntent);
            return true;
        }*/
        if (id == R.id.normal) {
            buttonNormalColor(res);
            crazy=false;
            superCrazy=false;
            buttonOriginalPosition();
            return true;
        }
        if (id == R.id.crazy) {
            buttonRandomColor(res);
            crazy=true;
            superCrazy=false;
            Toast.makeText(getApplicationContext(), "Crazy is on. Shake the device.", Toast.LENGTH_SHORT).show();
            return true;
        }if (id == R.id.superCrazy) {
            buttonRandomColor(res);
            randomPositions();
            crazy=true;
            superCrazy=true;
            Toast.makeText(getApplicationContext(), "Super Crazy is on. Shake the device.", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.instruction) {
            Intent instructionintent = new Intent(getApplicationContext(),Instruction.class);
            startActivity(instructionintent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
