package cn.whereyougo.cdialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;

import cn.whereyougo.cdialog.lib.CustomDialog;

/**
 * function : 对话框demo.
 * </p>
 * Created by lzj on 2016/1/11.
 */
public class MainActivity extends AppCompatActivity {
    private boolean revese = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static String[] mArrayData = new String[]{"aaa", "bbb", "ccc", "ddd", "eee", "fff"};

    public void showAlert(View v) {
        if (revese) {
            new CustomDialog.AlertBuilder(this)
                    .setTitleText("对话框")
                    .setContentText("这是对话框内容文本,这是对话框内容文本,这是对话框内容文本")
                    .setContentTextGravity(Gravity.CENTER)
                    .setPositiveBtn("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "click sure", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeBtn("取消", null)
                    .create()
                    .show();
        } else {
            ListView lv = new ListView(this);
            lv.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Arrays.asList(mArrayData)));
            final CustomDialog dialog = new CustomDialog.AlertBuilder(this).setTitleText("数据列表").setCustomContentView(lv).create();
            dialog.show();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "" + mArrayData[position], Toast.LENGTH_SHORT).show();
                }
            });
        }
        revese = !revese;
    }

    public void showLoading(View v) {
        final CustomDialog dialog = new CustomDialog.AlertBuilder(this)
                .setDialogWindowBgDimAcount(0f)//背景窗体不黑暗
                .setDialogBgColor(Color.TRANSPARENT)//对话框窗体透明背景
                .setTitleLayoutVisibility(View.GONE)//隐藏标题栏
                .setCustomContentViewGif(R.mipmap.gif)//设置gif图
                .setCanceledOnTouchOutside(false)//外触摸不消失
                .create();
        dialog.show();

        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 5000);
    }

    public void showLoadHUD(View view) {
        startActivity(new Intent(this, HUDActivity.class));
    }
}
