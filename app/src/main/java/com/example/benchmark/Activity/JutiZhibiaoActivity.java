package com.example.benchmark.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.benchmark.Adapter.JutiAdapter;
import com.example.benchmark.Data.JuTiData;
//import com.example.benchmark.Fragment.JuTiChuKongFragment;
//import com.example.benchmark.Fragment.JuTiCpuFragment;
//import com.example.benchmark.Fragment.JuTiLiuChangFragment;
//import com.example.benchmark.Fragment.JuTiWenDingFragment;
//import com.example.benchmark.Fragment.JuTiYinHuaFragment;
import com.example.benchmark.Data.MobileCloud;
import com.example.benchmark.R;

import java.util.ArrayList;
import java.util.List;

public class JutiZhibiaoActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageButton back;

    private TextView juti_phone_name,juti_grade;
    private Button back_ceping,next_zhibiao;

    private ImageView juti_img;
    private TextView juti_text,juti_item;

    private FragmentManager fragmentManager;

    private RecyclerView recyclerView;
    private List<JuTiData> data;

    private JutiAdapter jutiAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ceping_xiangxi);
        initview();
        back.setOnClickListener(this::onClick);
        back_ceping.setOnClickListener(this::onClick);
        Intent intent = getIntent();
        initdata(intent);
        jutiAdapter = new JutiAdapter(JutiZhibiaoActivity.this,data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(jutiAdapter);
    }


    void initview(){
        back=findViewById(R.id.jutizhibiao_fanhui);
        juti_phone_name=findViewById(R.id.juti_phone_name);
        juti_grade=findViewById(R.id.juti_grade);

        back_ceping=findViewById(R.id.juti_back_ceping);
        next_zhibiao=findViewById(R.id.juti_next_ceping);


        juti_img=findViewById(R.id.juti_image);
        juti_item=findViewById(R.id.juti_item);
        juti_text=findViewById(R.id.juti_text);

        recyclerView=findViewById(R.id.juti_rv);

    }

    @SuppressLint("SetTextI18n")
    void initdata(Intent intent){
        String select_plat = intent.getStringExtra("select_plat");
        String select_item = intent.getStringExtra("select_item");
        String select_text = intent.getStringExtra("select_text");
        Integer grade = intent.getIntExtra("select_grade",98);
        int select_img = intent.getIntExtra("select_img", R.drawable.blue_liuchang);

        juti_img.setImageResource(select_img);
        juti_text.setText(select_text);
        juti_item.setText(select_item);
        juti_phone_name.setText(select_plat+"??"+select_item);
        juti_grade.setText(String.valueOf(grade));


        out:switch (select_plat) {
            /**
             * ??????????????????
             */
            case "??????????????????": {
                in:switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break ;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "256G"));
                        break ;
                    }
                }
                break ;

            }




            case "???????????????": {
               in: switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break ;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "128G"));
                        break ;
                    }
                }
                break ;

            }


            /**
             * ???????????????
             */
            case "???????????????": {
                in:switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break ;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "64G"));
                        break ;
                    }
                }
                break ;



            }

            /**
             * ???????????????
             */
            case "???????????????": {
                in:switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break ;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "32G"));
                        break ;
                    }
                }
                break ;


            }


            case "????????????": {
               in:switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break ;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break ;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "33G"));
                        break ;
                    }
                }
                break ;



            }

            case "????????????": {
                in:switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break ;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break ;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break ;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break ;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break ;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "16G"));
                        break ;
                    }
                }
                break ;


            }


            case "???????????????": {
                switch (select_item) {
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("????????????(fps)", "29.7"));
                        data.add(new JuTiData("????????????(??????)", "1.06"));
                        data.add(new JuTiData("?????????(%)", "6.63%"));
                        data.add(new JuTiData("?????????(ms)", "22.93"));
                        data.add(new JuTiData("jank(????????????/10min)", "0.18"));
                        data.add(new JuTiData("??????????????????(%)", "0.76"));
                        break;
                    }
                    case "?????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????(%)", "96%"));
                        data.add(new JuTiData("????????????(ms)", "34ms"));
                        data.add(new JuTiData("????????????", "21ms"));
                        break;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("???????????????", "98%"));
                        data.add(new JuTiData("??????????????????", "21ms"));
                        break;
                    }
                    case "????????????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("?????????(px)", "1080x2440"));
                        data.add(new JuTiData("???????????????(ms)", "100ms"));
                        data.add(new JuTiData("????????????PSNR/SSIM(%)", "39%"));
                        data.add(new JuTiData("????????????PESQ", "1ms"));
                        break;
                    }
                    case "cpu": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("cpuName", "??????9000"));
                        data.add(new JuTiData("cpu??????", "??????9000"));
                        data.add(new JuTiData("cpu???????????????", "3.2GHz"));
                        data.add(new JuTiData("cpu?????????", MobileCloud.cpuCoreNum));
                        break;
                    }
                    case "gpu": {
                        data = new ArrayList<>();
                        break;
                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "12GG"));
                        data.add(new JuTiData("????????????", "500MB/S"));
                        break;

                    }
                    case "??????": {
                        data = new ArrayList<>();
                        data.add(new JuTiData("??????", "8G"));
                        break ;
                    }
                }
                break ;

            }
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jutizhibiao_fanhui:{
                finish();
                break;
            }
            case R.id.juti_back_ceping:{
                startActivity(new Intent(JutiZhibiaoActivity.this,CePingActivity.class));
                break;
            }

        }
    }
//    public  void  ChangeFragment(Fragment fragment, boolean isFisrt){
//        fragmentManager=getSupportFragmentManager();
//        //????????????
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.juti_fram,fragment);
//        if (!isFisrt){
//            fragmentTransaction.addToBackStack(null);;
//        }
//        fragmentTransaction.commit();
//    }
}
