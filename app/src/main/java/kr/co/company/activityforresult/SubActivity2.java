package kr.co.company.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity2 extends AppCompatActivity {

    // 2차 입력을 위한 EditText
    EditText edit2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃 생성, sub2.xml 파일을 화면으로 불러옴
        setContentView(R.layout.sub2);
        // 2차 데이터 입력을 위한 EditText 정의
        edit2 = (EditText) findViewById(R.id.edit2);

        // 입력 완료 버튼
        // 입력 완료 버튼을 누르면
        Button button_ok = (Button) findViewById(R.id.button_ok);
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // 인텐트 객체 생성
                Intent intent = new Intent();
                // INPUT_TEXT2라는 키에 edit2 값(2차 입력값)을 저장
                intent.putExtra("INPUT_TEXT2", edit2.getText().toString());
                setResult(RESULT_OK, intent);
                // 현재 액티비티 종료
                finish();
            }
        });

        // 취소 버튼
        Button button_cancel = (Button) findViewById(R.id.button_cancel);
        // 취소 버튼을 누르면
        button_cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                // 현재 액티비티 종료
                finish();
            }
        });
    }
}
