package in.co.mananarya.mallclues.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import in.co.mananarya.mallclues.R;
import in.co.mananarya.mallclues.models.Store;

/**
 * Created by Manan Arya on 7/4/2017.
 */

public class StoreAdapter extends ArrayAdapter<Store> {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    ArrayList<Store> mData;
    Context context;

    public StoreAdapter(Context context, ArrayList<Store> objects) {
        super(context, 0, objects);
        mData = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(this.context).inflate(R.layout.store_list_item, parent, false);
            TextView storeName = (TextView) v.findViewById(R.id.store_name);
            ImageView storeImage = (ImageView) v.findViewById(R.id.store_image);
            StoreAdapter.StoreHolder holder = new StoreAdapter.StoreHolder(storeName, storeImage);
            v.setTag(holder);
        }
        Store currentStore = mData.get(position);
        StoreAdapter.StoreHolder holder = (StoreAdapter.StoreHolder) v.getTag();
        holder.storeName.setText(currentStore.getName());


        StorageReference imagesRef = storageRef.child(currentStore.getRegion() + "Stores/" + currentStore.getStoreid() + ".jpg");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagesRef)
                .into(holder.storeImage);

        return v;

    }

    private static class StoreHolder {
        TextView storeName;
        ImageView storeImage;

        public StoreHolder(TextView storeName, ImageView storeImage) {
            this.storeName = storeName;
            this.storeImage = storeImage;
        }
    }

}
