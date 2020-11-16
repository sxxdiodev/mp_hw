package kr.co.company.activityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // requestCode 정의
    static final int GET_STRING = 1;
    // 메인 엑티비티에서 출력할 2개의 문자열
    TextView text1;
    TextView text2;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        // 레이아웃 생성, activity.main.xml 파일을 화면에 불러옴
        setContentView(R.layout.activity_main);

        // 서브액티비티로 넘어가기 위한 버튼
        Button button = (Button) findViewById(R.id.button);
        // 1차 입력
        text1 = (TextView) findViewById(R.id.text1);
        // 2차 입력
        text2 = (TextView) findViewById(R.id.text2);
        // 버튼 눌렀을때 실행되는 이벤트 함
        button.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                // 인텐트 객체 생성
                Intent in = new Intent(MainActivity.this, SubActivity.class);
                // 서브액티비티를 시작하도록 함
                startActivityForResult(in, GET_STRING);
            }
        });
    }

    @Override
    // 서브 액티비티로부터 결과를 받는 함수
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            // resultCode가 RESULT_OK라면
            if (resultCode == RESULT_OK) {
                // 엑스트라 필드에서 서브 액티비티의 결과값을 추출함
                text1.setText(data.getStringExtra("INPUT_TEXT"));
                text2.setText(data.getStringExtra("INPUT_TEXT2"));
            }
        }
    }
}
