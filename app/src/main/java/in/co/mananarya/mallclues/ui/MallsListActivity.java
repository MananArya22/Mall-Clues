package in.co.mananarya.mallclues.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.co.mananarya.mallclues.R;
import in.co.mananarya.mallclues.adapters.MallAdapter;
import in.co.mananarya.mallclues.models.Mall;
import in.co.mananarya.mallclues.utility.Utils;

public class MallsListActivity extends AppCompatActivity {

    ListView mMallListView;
    String region;


    DatabaseReference mRootRef = Utils.getDatabase().getInstance().getReference();
    DatabaseReference mRegionRefrence;
    DatabaseReference mMallsRefrence;
    ArrayList<Mall> data;
    MallAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mallslist);
        mMallListView = (ListView) findViewById(R.id.malls_list);
        data = new ArrayList<>();
        adapter = new MallAdapter(this, data);
        mMallListView.setAdapter(adapter);
        mMallListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.setClass(MallsListActivity.this, MallInformationActivity.class);
                Mall clickedMall = (Mall) parent.getAdapter().getItem(position);
                i.putExtra("name", clickedMall.getName());
                i.putExtra("id", clickedMall.getId());
                i.putExtra("address", clickedMall.getAddress());
                i.putExtra("description", clickedMall.getDescription());
                i.putExtra("developer", clickedMall.getDeveloper());
                i.putExtra("guestServices", clickedMall.getGuestServices());
                i.putExtra("location", clickedMall.getLocation());
                i.putExtra("phoneNumber", clickedMall.getPhoneNumber());
                i.putExtra("region", clickedMall.getRegion());
                i.putExtra("website", clickedMall.getWebsite());
                startActivity(i);
            }
        });

        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mRootRef.keepSynced(true);
        region = getIntent().getStringExtra("selectedRegion");

    }

    @Override
    protected void onStart() {
        super.onStart();
        mRegionRefrence = mRootRef.child(region);
        mMallsRefrence = mRegionRefrence.child("malls");

        mMallsRefrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot mall : dataSnapshot.getChildren()) {
                    String mallName = mall.child("name").getValue(String.class);
                    Log.i("mallInfo", mallName);
                    String id = mall.child("id").getValue(String.class);
                    Log.i("mallInfo", id);
                    String address = mall.child("address").getValue(String.class);
                    Log.i("mallInfo", address);
                    String description = mall.child("description").getValue(String.class);
                    Log.i("mallInfo", description);
                    String developer = mall.child("developer").getValue(String.class);
                    Log.i("mallInfo", developer);
                    String guestServices = mall.child("guestservices").getValue(String.class);
                    Log.i("mallInfo", guestServices);
                    String location = mall.child("name").getValue(String.class);
                    Log.i("mallInfo", location);
                    String phoneNumber = mall.child("phonenumber").getValue(String.class);
                    Log.i("mallInfo", phoneNumber);
                    String region = mall.child("region").getValue(String.class);
                    Log.i("mallInfo", region);
                    String website = mall.child("website").getValue(String.class);
                    Log.i("mallInfo", website);
                    int mallImages = Integer.parseInt(mall.child("mallimages").getValue(String.class));
                    Log.i("mallInfo", mallImages + "");
                    Mall m = new Mall(mallName, id, address, description, developer, guestServices, location, phoneNumber, region, website, mallImages);
                    data.add(m);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
