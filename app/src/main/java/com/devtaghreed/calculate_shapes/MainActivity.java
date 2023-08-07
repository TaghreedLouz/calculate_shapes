package com.devtaghreed.calculate_shapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.devtaghreed.calculate_shapes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mainSpShapes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        //Rectangle
                        binding.mainEtRectangleHeight.setVisibility(View.VISIBLE);
                        binding.mainEtRectangleWidth.setVisibility(View.VISIBLE);
                        binding.mainEtCircleRadius.setVisibility(View.GONE);
                        binding.mainEtTriangleBase.setVisibility(View.GONE);
                        binding.mainEtTriangleHeight.setVisibility(View.GONE);
                        break;

                    case 1:
                        //Circle
                        binding.mainEtRectangleHeight.setVisibility(View.GONE);
                        binding.mainEtRectangleWidth.setVisibility(View.GONE);
                        binding.mainEtCircleRadius.setVisibility(View.VISIBLE);
                        binding.mainEtTriangleBase.setVisibility(View.GONE);
                        binding.mainEtTriangleHeight.setVisibility(View.GONE);
                        break;

                    default:
                        //Triangle
                        binding.mainEtRectangleHeight.setVisibility(View.GONE);
                        binding.mainEtRectangleWidth.setVisibility(View.GONE);
                        binding.mainEtCircleRadius.setVisibility(View.GONE);
                        binding.mainEtTriangleBase.setVisibility(View.VISIBLE);
                        binding.mainEtTriangleHeight.setVisibility(View.VISIBLE);


                }
//                if (i==0){
//                    //Rectangle
//                    binding.mainEtRectangleHeight.setVisibility(View.VISIBLE);
//                    binding.mainEtRectangleWidth.setVisibility(View.VISIBLE);
//                    binding.mainEtCircleRadius.setVisibility(View.GONE);
//                    binding.mainEtTriangleBase.setVisibility(View.GONE);
//                    binding.mainEtTriangleHeight.setVisibility(View.GONE);
//                } else if (i==1){
//                    //Circle
//                    binding.mainEtRectangleHeight.setVisibility(View.GONE);
//                    binding.mainEtRectangleWidth.setVisibility(View.GONE);
//                    binding.mainEtCircleRadius.setVisibility(View.VISIBLE);
//                    binding.mainEtTriangleBase.setVisibility(View.GONE);
//                    binding.mainEtTriangleHeight.setVisibility(View.GONE);
//
//
//                } else {
//
//                    //Triangle
//                    binding.mainEtRectangleHeight.setVisibility(View.GONE);
//                    binding.mainEtRectangleWidth.setVisibility(View.GONE);
//                    binding.mainEtCircleRadius.setVisibility(View.GONE);
//                    binding.mainEtTriangleBase.setVisibility(View.VISIBLE);
//                    binding.mainEtTriangleHeight.setVisibility(View.VISIBLE);
//                }
                }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Rectangle -> w * h
        // Circle -> pi * r *r
        //Triangle- -> 0.5 * base * h

        binding.mainBtnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = binding.mainSpShapes.getSelectedItemPosition();
                double area = 0;
                if (index==0){
                    //Rectangle
                    double rect_width = Double.parseDouble(binding.mainEtRectangleWidth.getText().toString());
                    double rect_height = Double.parseDouble(binding.mainEtRectangleHeight.getText().toString());
                    area = rect_width * rect_height;
                } else if (index==1){
                    //Circle
                    double cir_radius = Double.parseDouble(binding.mainEtCircleRadius.getText().toString());
                    area = Math.PI * Math.pow(cir_radius, 2);


                } else {
                    //Triangle
                    double Tri_base = Double.parseDouble(binding.mainEtTriangleBase.getText().toString());
                    double Tri_height = Double.parseDouble(binding.mainEtTriangleHeight.getText().toString());
                    area = 0.5 * Tri_base * Tri_height;
                }
                binding.mainTvResult.setText(area + "");
                binding.mainEtCircleRadius.setText("");
                binding.mainEtTriangleHeight.setText("");
                binding.mainEtTriangleBase.setText("");
                binding.mainEtRectangleWidth.setText("");
                binding.mainEtRectangleHeight.setText("");
            }
        });

    }
}