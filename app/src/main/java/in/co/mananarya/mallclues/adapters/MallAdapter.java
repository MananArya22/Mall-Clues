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

import in.co.mananarya.mallclues.models.Mall;
import in.co.mananarya.mallclues.R;

/**
 * Created by Manan Arya on 7/3/2017.
 */

public class MallAdapter extends ArrayAdapter<Mall> {

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReference();

    ArrayList<Mall> mData;
    Context context;

    public MallAdapter(Context context, ArrayList<Mall> objects) {
        super(context, 0, objects);
        mData = objects;
        this.context = context;
    }

    private static class MallHolder {
        TextView mallName;
        ImageView mallImage;

        public MallHolder(TextView mallName, ImageView mallImage) {
            this.mallName = mallName;
            this.mallImage = mallImage;
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(this.context).inflate(R.layout.mall_list_item, parent, false);
            TextView mallName = (TextView) v.findViewById(R.id.mall_name);
            ImageView mallImage = (ImageView) v.findViewById(R.id.mall_image);
            MallHolder holder = new MallHolder(mallName, mallImage);
            v.setTag(holder);
        }
        Mall currentMall = mData.get(position);
        MallHolder holder = (MallHolder) v.getTag();
        holder.mallName.setText(currentMall.getName());


        StorageReference imagesRef = storageRef.child(currentMall.getId() + "/p1.jpg");

        Glide.with(context)
                .using(new FirebaseImageLoader())
                .load(imagesRef)
                .into(holder.mallImage);

        return v;

    }
}
