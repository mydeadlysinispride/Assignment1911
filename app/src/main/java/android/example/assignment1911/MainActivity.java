package android.example.assignment1911;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editName;
    EditText editMSSV;
    EditText editDate;
    EditText editSex;
    EditText editAddress;
    EditText editPhone;
    EditText editEmail;
    CheckBox checkAgreement;
    Button Submit;
    boolean Check;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.edit_name);
        editMSSV = findViewById(R.id.edit_mssv);
        editDate = findViewById(R.id.edit_date);
        editSex = findViewById(R.id.edit_sex);
        editAddress = findViewById(R.id.edit_address);
        editPhone = findViewById(R.id.edit_phone);
        editEmail = findViewById(R.id.edit_email);
        checkAgreement = findViewById(R.id.check_agree);

        Submit = findViewById(R.id.button_submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check = checkDataEnter();
                if(Check==true){
                    Intent intent = new Intent(MainActivity.this,SubmitActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return  TextUtils.isEmpty(str);
    }
    boolean checkDataEnter(){
        if(isEmpty(editName)){
            Toast t = Toast.makeText(this,"B???n c???n nh???p t??n!", Toast.LENGTH_SHORT );
            t.show();
            return false;
        }
        if(isEmpty(editMSSV)){
            editMSSV.setError("C???n nh???p m?? s??? sinh vi??n!");
            return false;
        }
        if(isEmpty((editDate))){
            editDate.setError("C???n nh???p ng??y sinh!");
            return false;
        }
        if(isEmpty(editPhone)){
            editPhone.setError("C???n nh???p s??? ??i???n tho???i!");
            return false;
        }
        if(isEmail(editEmail)==false){
            editEmail.setError("Nh???p v??o email ch??nh x??c!");
            return false;
        }
        if(!checkAgreement.isChecked()){
            checkAgreement.setError("C???n ?????ng ?? ??i???u kho???n s??? d???ng");
            return false;
        }
        return true;

    }
}