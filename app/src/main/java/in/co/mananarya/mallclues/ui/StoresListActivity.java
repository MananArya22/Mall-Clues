package in.co.mananarya.mallclues.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import in.co.mananarya.mallclues.R;
import in.co.mananarya.mallclues.adapters.StoreAdapter;
import in.co.mananarya.mallclues.models.Store;
import in.co.mananarya.mallclues.utility.Utils;

public class StoresListActivity extends AppCompatActivity {

    ListView mStoresListView;
    String region;
    String mallid;
    String category;
    String mallname;
    String malladdress;
    DatabaseReference mRootRef = Utils.getDatabase().getInstance().getReference();
    DatabaseReference mRegionRefrence;
    ArrayList<Store> data;
    StoreAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storeslist);
        mStoresListView = (ListView) findViewById(R.id.stores_list);
        data = new ArrayList<>();
        adapter = new StoreAdapter(this, data);
        mStoresListView.setAdapter(adapter);

        mRootRef.keepSynced(true);

        region = getIntent().getStringExtra("Region");
        mallid = getIntent().getStringExtra("MallId");
        category = getIntent().getStringExtra("Category");
        mallname = getIntent().getStringExtra("MallName");
        malladdress = getIntent().getStringExtra("MallAddress");

        mStoresListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent();
                i.setClass(StoresListActivity.this, StoreInformationActivity.class);
                Store clickedStore = (Store) parent.getAdapter().getItem(position);
                i.putExtra("Name", clickedStore.getName());
                i.putExtra("StoreId", clickedStore.getStoreid());
                i.putExtra("Region", clickedStore.getRegion());
                i.putExtra("MallId", clickedStore.getMallid());
                i.putExtra("Offers", clickedStore.getOffers());
                i.putExtra("PhoneNumber", clickedStore.getPhonenumber());
                i.putExtra("MallName", mallname);
                i.putExtra("Address", clickedStore.getAddress());
                i.putExtra("Category", clickedStore.getCategory());
                i.putExtra("Description", clickedStore.getDescription());
                i.putExtra("MallAddress", malladdress);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRegionRefrence = mRootRef.child(region);
        DatabaseReference mTempRefrence = mRegionRefrence.child("categoryBasedStores");
        DatabaseReference mMallRefrence = mTempRefrence.child(mallid);
        DatabaseReference mCategoryRefrence = mMallRefrence.child(category);

        mCategoryRefrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot store : dataSnapshot.getChildren()) {
                    String storeName = store.child("name").getValue(String.class);
                    String storeId = store.child("storeid").getValue(String.class);
                    String storePhonenumber = store.child("phonenumber").getValue(String.class);
                    String storeOffers = store.child("offers").getValue(String.class);
                    String storeDescription = store.child("description").getValue(String.class);
                    String storeAddress = store.child("address").getValue(String.class);
                    String storeCategory = store.child("category").getValue(String.class);
                    String mallId = store.child("mallid").getValue(String.class);
                    String storeRegion = store.child("region").getValue(String.class);

                    Store s = new Store(storeName, storeAddress, storeCategory, storeDescription, mallId, storeOffers, storePhonenumber, storeRegion, storeId);
                    data.add(s);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
