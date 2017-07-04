package in.co.mananarya.mallclues.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import in.co.mananarya.mallclues.R;

public class MainActivity extends AppCompatActivity {

    Button northRegion;
    Button westRegion;
    Button eastRegion;
    Button southRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);

        northRegion = (Button) findViewById(R.id.region_north);
        eastRegion = (Button) findViewById(R.id.region_east);
        westRegion = (Button) findViewById(R.id.region_west);
        southRegion = (Button) findViewById(R.id.region_south);

        northRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MallsListActivity.class);
                i.putExtra("selectedRegion", "north");
                Log.i("region", "north");
                startActivity(i);
            }
        });

        westRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MallsListActivity.class);
                i.putExtra("selectedRegion", "west");
                Log.i("region", "west");
                startActivity(i);
            }
        });

        eastRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MallsListActivity.class);
                i.putExtra("selectedRegion", "east");
                Log.i("region", "east");
                startActivity(i);
            }
        });

        southRegion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MallsListActivity.class);
                i.putExtra("selectedRegion", "south");
                Log.i("region", "south");
                startActivity(i);
            }
        });


    }
}
