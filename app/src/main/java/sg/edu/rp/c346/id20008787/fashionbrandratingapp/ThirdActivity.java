package sg.edu.rp.c346.id20008787.fashionbrandratingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    EditText etID, etTitle, etCountrys, etYears;
    RatingBar rBar;
    Button btnCancel, btnUpdate, btnDelete;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        setTitle(getTitle().toString() + " ~ " + getResources().getText(R.string.title_activity_third));


        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        etID = (EditText) findViewById(R.id.etID);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etCountrys = (EditText) findViewById(R.id.etCountrys);
        etYears = (EditText) findViewById(R.id.etYears);

        Intent i = getIntent();
        final Brand currentBrand = (Brand) i.getSerializableExtra("brand");

        etID.setText(currentBrand.getId()+"");
        etTitle.setText(currentBrand.getTitle());
        etCountrys.setText(currentBrand.getCountrys());
        etYears.setText(currentBrand.getYearReleased()+"");


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                currentBrand.setTitle(etTitle.getText().toString().trim());
                currentBrand.setCountrys(etCountrys.getText().toString().trim());
                int year = 0;
                try {
                    year = Integer.valueOf(etYears.getText().toString().trim());
                } catch (Exception e){
                    Toast.makeText(ThirdActivity.this, "Invalid year", Toast.LENGTH_SHORT).show();
                    return;
                }
                currentBrand.setYearReleased(year);

                int selectedRB = rBar.getCheckedRatingBarId();
                currentSong.setStars(Integer.parseInt(rb.getText().toString()));
                int result = dbh.updateSong(currentBrand);
                if (result>0){
                    Toast.makeText(ThirdActivity.this, "Song updated", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ThirdActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                int result = dbh.deleteSong(currentBrand.getId());
                if (result>0){
                    Toast.makeText(ThirdActivity.this, "Song deleted", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(ThirdActivity.this, "Delete failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}