package com.skyler.badgeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private BadgeView badgeView;
    private BadgeView bvIcon;

    private CheckBox cbShowNum;

    private EditText etBadgeNum;
    private Button btnSetNum;

    private EditText etBadgeLeft;
    private EditText etBadgeBottom;
    private Button btnBadgeLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        badgeView = (BadgeView) findViewById(R.id.badge_view_with_text);
        bvIcon = (BadgeView) findViewById(R.id.badge_view_with_icon);

        cbShowNum = (CheckBox) findViewById(R.id.cb_show_num);

        etBadgeNum = (EditText) findViewById(R.id.et_badgenum);
        btnSetNum = (Button) findViewById(R.id.btn_set_num);

        etBadgeLeft = (EditText) findViewById(R.id.et_badge_left);
        etBadgeBottom = (EditText) findViewById(R.id.et_badge_bottom);
        btnBadgeLocation = (Button) findViewById(R.id.btn_set_badge_location);

        cbShowNum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                badgeView.setShowNum(isChecked);
                badgeView.redraw();
                bvIcon.setShowNum(isChecked);
                bvIcon.redraw();
            }
        });
        btnSetNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etBadgeNum.getText().toString().trim();
                try {
                    int num = Integer.parseInt(text);
                    badgeView.setBadgeNum(num);
                    badgeView.redraw();
                    bvIcon.setBadgeNum(num);
                    bvIcon.redraw();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        btnBadgeLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bottomStr = etBadgeBottom.getText().toString().trim();
                String leftStr = etBadgeLeft.getText().toString().trim();
                try {
                    int bottom = Integer.parseInt(bottomStr);
                    int left = Integer.parseInt(leftStr);
                    badgeView.setBadgeLocation(bottom, left);
                    badgeView.redraw();
                    bvIcon.setBadgeLocation(bottom, left);
                    bvIcon.redraw();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
