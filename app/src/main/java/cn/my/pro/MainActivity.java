package cn.my.pro;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import cn.my.core.MathUtils;


public class MainActivity extends AppCompatActivity {

    // Used to load the 'pro' library on application startup.
    static {
        System.loadLibrary("pro");
    }

    final private String TAG = "dlog";
    private TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textViewId);
    }

    /**
     * A native method that is implemented by the 'pro' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public void test1(View view) {
        int a = 10;
        int b = 20;
        int result = MathUtils.add(a, b);
        String text = "MathUtils.add call return:" + result;
        tv.setText(text);
    }

    public void test2(View view) {
        int a = 10;
        int b = 20;
        cn.my.core2.MathUtils mathUtils = new cn.my.core2.MathUtils();
        int result = mathUtils.mul_java(a, b);
        String text = "test 2 mul return:" + result;
        tv.setText(text);
    }

    public void test3(View view) {
        int a = 10;
        int b = 20;
        int result = cn.my.core3.MathUtils.add(a, b);
        String text = "test 2 mul return:" + result;
        tv.setText(text);
    }
}