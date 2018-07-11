package com.framgia.tipcalculator;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    private TextView text;
    private TextView kq;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btncong;
    private Button btntru;
    private Button btnnhan;
    private Button btnchia;

    private Button btnpt;
    private Button btntp;
    private Button btnbang;
    private Button btnac;
    private Button btnam;
    private Button btndel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculator, container, false);
        text = view.findViewById(R.id.text);
        kq = view.findViewById(R.id.kq);
        btn0 = view.findViewById(R.id.btn_0);
        btn1 = view.findViewById(R.id.btn_1);
        btn2 = view.findViewById(R.id.btn_2);
        btn3 = view.findViewById(R.id.btn_3);
        btn4 = view.findViewById(R.id.btn_4);
        btn5 = view.findViewById(R.id.btn_5);
        btn6 = view.findViewById(R.id.btn_6);
        btn7 = view.findViewById(R.id.btn_7);
        btn8 = view.findViewById(R.id.btn_8);
        btn9 = view.findViewById(R.id.btn_9);
        btntp = view.findViewById(R.id.btn_tp);
        btnam= view.findViewById(R.id.btn_am);
        btncong = view.findViewById(R.id.btn_cong);
        btntru = view.findViewById(R.id.btn_tru);
        btnnhan = view.findViewById(R.id.btn_nhan);
        btnchia = view.findViewById(R.id.btn_chia);
        btnpt = view.findViewById(R.id.btn_pt);
        btnac = view.findViewById(R.id.btn_ac);
        btndel = view.findViewById(R.id.btn_del);
        btnbang = view.findViewById(R.id.btn_bang);
        setButton();
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back_menu:
                kq.setText("0");
                text.setText(" ");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setButton() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btntp.setOnClickListener(this);
        btnam.setOnClickListener(this);
        btnpt.setOnClickListener(this);
        btncong.setOnClickListener(this);
        btntru.setOnClickListener(this);
        btnnhan.setOnClickListener(this);
        btnchia.setOnClickListener(this);
        btnac.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnbang.setOnClickListener(this);
    }
    public String delete(String num){
        int lenght = num.length();
        String tem = num.substring(0,lenght-1);
        return tem;

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_0 :
                text.append("0");
                break;
            case R.id.btn_1 :
                text.append("1");
                break;
            case R.id.btn_2 :
                text.append("2");
                break;
            case R.id.btn_3 :
                text.append("3");
                break;
            case R.id.btn_4 :
                text.append("4");
                break;
            case R.id.btn_5 :
                text.append("5");
                break;
            case R.id.btn_6 :
                text.append("6");
                break;
            case R.id.btn_7 :
                text.append("7");
                break;
            case R.id.btn_8 :
                text.append("8");
                break;
            case R.id.btn_9 :
                text.append("9");
                break;
            case R.id.btn_am :
                text.append("-");
                break;
            case R.id.btn_pt:
                text.append("%");
                break;
            case R.id.btn_tp:
                text.append(".");
                break;
            case R.id.btn_cong :
                text.append("+");
                break;
            case R.id.btn_tru:
                text.append("-");
                break;
            case R.id.btn_nhan:
                text.append("*");
                break;
            case R.id.btn_chia:
                text.append("/");
                break;
            case R.id.btn_bang:
                DecimalFormat df = new DecimalFormat("###.#######");
                double result = 0;
                addPhepTinh(text.getText().toString());
                addSo(text.getText().toString());
                // Thuật toán tính toán biểu thức
                if(pheptinh.size()>=so.size() ||pheptinh.size()<1){
                    kq.setText("Error");
                }else {
                    for (int i = 0; i < (so.size() - 1); i++) {
                        switch (pheptinh.get(i)) {
                            case "+":
                                if (i == 0) {
                                    result = so.get(i) + so.get(i + 1);
                                } else {
                                    result = result + so.get(i + 1);
                                }
                                break;
                            case "-":
                                if (i == 0) {
                                    result = so.get(i) - so.get(i + 1);
                                } else {
                                    result = result - so.get(i + 1);
                                }
                                break;
                            case "*":
                                if (i == 0) {
                                    result = so.get(i) * so.get(i + 1);
                                } else {
                                    result = result * so.get(i + 1);
                                }
                                break;
                            case "/":
                                if (i == 0) {
                                    result = so.get(i) / so.get(i + 1);
                                } else {
                                    result = result / so.get(i + 1);
                                }
                                break;
                            case "%":
                                if (i == 0) {
                                    result = (so.get(i) / so.get(i + 1))*100;
                                } else {
                                    result = result / so.get(i + 1);
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    kq.setText(df.format(result) + "");
                }
                break;
            case R.id.btn_ac:
                text.setText("");
                kq.setText("0");
                break;
            case R.id.btn_del:
                String del = delete(text.getText().toString());
                text.setText(del);
                break;
        }

    }
    ArrayList<String> pheptinh;
    ArrayList<Double> so;


    public int addPhepTinh(String a){
        pheptinh = new ArrayList<>();
        char[] cArray = a.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            switch (cArray[i]) {
                case '+':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '-':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '*':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '/':
                    pheptinh.add(cArray[i] + "");
                    break;
                case '%':
                    pheptinh.add(cArray[i] + "");
                    break;
                default:
                    break;
            }
        }
        return 0;
    }
    public void addSo(String stringInput) {
        so = new ArrayList<>();
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(stringInput);
        while(matcher.find()){
            so.add(Double.valueOf(matcher.group(1)));
        }
    }
}
