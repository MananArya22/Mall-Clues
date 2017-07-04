package in.co.mananarya.mallclues.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import in.co.mananarya.mallclues.R;

public class StoreInformationActivity extends AppCompatActivity {

    TextView StoreName;
    TextView StoreAddress;
    TextView StoreOffers;
    TextView StoreContact;
    TextView StoreDescription;
    TextView StoreCategory;

    ImageView StoreImage;

    String StoreId;
    String MallId;
    String Region;
    String MallName;
    String mallAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeinfo);

        StoreName = (TextView) findViewById(R.id.Name_Store);
        StoreAddress = (TextView) findViewById(R.id.Address_Store);
        StoreOffers = (TextView) findViewById(R.id.Store_Offers);
        StoreContact = (TextView) findViewById(R.id.Store_Contact);
        StoreDescription = (TextView) findViewById(R.id.Store_Description);
        StoreCategory = (TextView) findViewById(R.id.Store_Category);
        StoreImage = (ImageView) findViewById(R.id.Image_Store);

        MallName = getIntent().getStringExtra("MallName");
        StoreId = getIntent().getStringExtra("StoreId");
        Region = getIntent().getStringExtra("Region");
        MallId = getIntent().getStringExtra("MallId");
        mallAddress = getIntent().getStringExtra("MallAddress");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.Store_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mallAddress != null) {
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + MallName + ", " + mallAddress);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    startActivity(mapIntent);
                }

            }
        });


        String Name = getIntent().getStringExtra("Name");
        if (Name != null) {
            StoreName.setText(Name);
        }
        String Offers = getIntent().getStringExtra("Offers");
        if (Offers != null) {
            StoreOffers.setText("Offers: " + Offers);
        }
        String PhoneNumber = getIntent().getStringExtra("PhoneNumber");
        if (PhoneNumber != null) {
            StoreContact.setText("Contact: " + PhoneNumber);
        }

        String Address = getIntent().getStringExtra("Address");
        if (Address != null && MallName != null) {
            StoreAddress.setText("Address: " + Address + ", " + MallName);
        }
        String Category = getIntent().getStringExtra("Category");
        if (Category != null) {
            StoreCategory.setText("Category: " + Category);
        }
        String Description = getIntent().getStringExtra("Description");
        if (Description != null) {
            StoreDescription.setText("Description: " + Description);
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference imagesRef = storageRef.child(Region + "Stores/" + StoreId + ".jpg");

        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(imagesRef)
                .into(StoreImage);
    }
}
