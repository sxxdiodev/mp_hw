package kr.co.company.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SubActivity extends AppCompatActivity {
    // requestCode 정의
    static final int GET_STRING = 1;
    // 1차 입력을 할 EditText 정의
    EditText edit;
    // 서브액티비티2 에서 입력한 2차 입력값을 출력하기 위한 TextView 정의
    TextView text;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 레이아웃 생성, sub.xml 파일을 화면으로 불러옴
        setContentView(R.layout.sub);

        // 2차 데이터 입력을 위한 버튼
        Button button = (Button) findViewById(R.id.button_2ndDataInput);
        // 2차 입력값을 출력할 텍스트
        text = (TextView) findViewById(R.id.input2);
        // 서브액티비티 2를 시작
        button.setOnClickListener(new View.OnClickListener() {
            // @Override
            public void onClick(View arg0) {
                // 인텐트 객체 생성
                Intent in = new Intent(SubActivity.this, SubActivity2.class);
                // 서브액티비티2를 시작하도록 함
                startActivityForResult(in, GET_STRING);
            }
        });

        // 1차입력을 위한 editText
        edit = (EditText) findViewById(R.id.edit);

        // 입력 완료 버튼
        Button button_ok = (Button) findViewById(R.id.button_ok);
        // 입력 완료 버튼을 누르면
        button_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    // 인텐트 객체 생성
                    Intent intent = new Intent();
                    // INPUT_TEXT라는 키에 edit의 값(1차 입력값)을 저장
                    intent.putExtra("INPUT_TEXT", edit.getText().toString());
                    setResult(RESULT_OK, intent);
                    // INPUT_TEXT2라는 키에 text 값(2차 입력값)을 저장
                    intent.putExtra("INPUT_TEXT2", text.getText().toString());
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
                // 현재의 액티비티 종료
                finish();
            }
        });
    }

    // 서브 액티비티2로부터 결과를 받는 함수
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == GET_STRING) {
            // resultCode가 RESULT_OK라면
            if (resultCode == RESULT_OK) {
                // INPUT_TEXT2의 키에 해당하는 값을 2차 입력값으로 서브액티비티에 출력
                text.setText(data.getStringExtra("INPUT_TEXT2"));
            }
        }
    }
}
