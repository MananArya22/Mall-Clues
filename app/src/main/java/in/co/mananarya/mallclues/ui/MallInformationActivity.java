package in.co.mananarya.mallclues.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import in.co.mananarya.mallclues.R;

public class MallInformationActivity extends AppCompatActivity {

    TextView nameT;
    TextView addressT;
    TextView descriptionT;
    TextView developerT;
    TextView guestServicesT;
    TextView phoneNumberT;
    TextView websiteT;

    ImageView mallImage1;
    ImageView mallImage2;

    Button clothing;
    Button food;
    Button footwear;
    Button entertainment;
    Button all;
    Button electronics;
    Button updateFormButton;

    String name;
    String address;
    String id;
    String region;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mallinfo);
        nameT = (TextView) findViewById(R.id.Name_Mall);
        addressT = (TextView) findViewById(R.id.Address_Mall);
        descriptionT = (TextView) findViewById(R.id.Mall_Description);
        developerT = (TextView) findViewById(R.id.Mall_Developer);
        guestServicesT = (TextView) findViewById(R.id.Mall_GuestServices);
        phoneNumberT = (TextView) findViewById(R.id.Mall_Contact);
        websiteT = (TextView) findViewById(R.id.Mall_Website);

        mallImage1 = (ImageView) findViewById(R.id.Image_Mall);
        mallImage2 = (ImageView) findViewById(R.id.Mall_SecondImage);

        clothing = (Button) findViewById(R.id.button_clothing);
        food = (Button) findViewById(R.id.button_food);
        footwear = (Button) findViewById(R.id.button_footwear);
        entertainment = (Button) findViewById(R.id.button_entertainment);
        all = (Button) findViewById(R.id.button_allstores);
        electronics = (Button) findViewById(R.id.button_electronics);
        updateFormButton = (Button) findViewById(R.id.UpdateFormButton);


        name = getIntent().getStringExtra("name");
        if (name != null) {
            nameT.setText(name);
        }
        address = getIntent().getStringExtra("address");
        if (address != null) {
            addressT.setText("Address: " + address);
        }

        final String location = getIntent().getStringExtra("location");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (location != null) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + name + ", " + address);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }

            }
        });

        updateFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://goo.gl/forms/gGwLY7xe3gKAFm563";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });


        String description = getIntent().getStringExtra("description");
        if (description != null) {
            descriptionT.setText("About The Mall \n" + description);
        }
        String developer = getIntent().getStringExtra("developer");
        if (developer != null) {
            developerT.setText("Developer: " + developer);
        }
        String guestServices = getIntent().getStringExtra("guestServices");
        if (guestServices != null) {
            guestServicesT.setText("Guest Services: " + guestServices);
        }

        String phoneNumber = getIntent().getStringExtra("phoneNumber");
        if (phoneNumber != null) {
            phoneNumberT.setText("Contact us at: " + phoneNumber);
        }
        String website = getIntent().getStringExtra("website");
        if (website != null) {
            websiteT.setText("Website: " + website);
        }

        id = getIntent().getStringExtra("id");
        region = getIntent().getStringExtra("region");

        clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "clothing");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                Log.i("Address", address);
                startActivity(i);
            }
        });

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "allStores");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                startActivity(i);
            }
        });

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "entertainment");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                startActivity(i);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "food");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                startActivity(i);
            }
        });

        footwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "footwear");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                startActivity(i);
            }
        });

        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MallInformationActivity.this, StoresListActivity.class);
                i.putExtra("MallId", id);
                i.putExtra("Region", region);
                i.putExtra("Category", "electronics");
                i.putExtra("MallName", name);
                i.putExtra("MallAddress", address);
                startActivity(i);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child(id + "/p2.jpg");

        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(imagesRef)
                .into(mallImage1);

        imagesRef = storageRef.child(id + "/p3.jpg");

        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(imagesRef)
                .into(mallImage2);

    }
}
