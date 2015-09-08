package com.kpr.hus.dynamicbutton;

import android.widget.TextView;

/**
 * Created by a09348 on 9/4/2015.
 */
public class Method {

    public static Double method(Character operatorSign, Character operator,Double num1, Double num2,Double result, TextView res, TextView tvOpt,TextView tvN1, TextView tvN2,
                        Boolean progress ){

                if(operator==' '){
                    // it happen when press+
                    tvOpt.setText(operator.toString());
                    try {
                        num1 = Double.parseDouble(res.getText().toString());
                    }catch(Exception e){
                        System.out.print("Wrong button pressed");
                    }
                    res.setText("");tvOpt.setText("+"+ " ");tvN1.setText(num1.toString());
                    operator='+';
                    progress=true;
                    result=operation(operatorSign,result,num1,num2);
                    tvN2.setText("");
return result;
                }
                else if(operator=='+' &&  operatorSign=='+') {
                    // it happen when press++
                    tvOpt.setText(        operatorSign.toString()+" ");
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
                    result=operation(operatorSign,result,num1,num2);
                    return result;
                }

                else if(operator=='-' &&         operatorSign=='+'){
// it happen when press-- then press+
                    if (progress){
                        if(res.getText().length()==0){
                            tvOpt.setText(        operatorSign.toString()+" ");
                            try {
                                num1 = Double.parseDouble(res.getText().toString());
                            }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            res.setText("");tvOpt.setText("+"+ " ");tvN1.setText(num1.toString());
                                    operatorSign='+';
                            progress=true;

                            tvN2.setText("");
                            result=operation(operatorSign,result,num1,num2);
                            return result;
                        }

                        else{
                            // it happen when press-- then press+
                            try {
                               num2 = Double.parseDouble(res.getText().toString());
                              }catch(Exception e){
                                System.out.print("Wrong button pressed");
                            }
                            Double resssult=operation(        operatorSign,result,num1,num2);
                            num1=resssult;
                            tvN1.setText(resssult.toString());
                            tvN2.setText("");
                            tvOpt.setText("+"+ " ");
                            res.setText("");
                                    operatorSign='+';}
                        result=operation(operatorSign,result,num1,num2);
                        return result;
            }

        }
        return result;
    }
    public static double operation(Character operator,Double result,Double num1,Double num2) {
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
}
