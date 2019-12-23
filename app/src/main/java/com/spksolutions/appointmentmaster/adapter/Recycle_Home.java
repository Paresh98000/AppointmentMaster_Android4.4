package com.spksolutions.appointmentmaster.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.spksolutions.appointmentmaster.R;

import static android.view.View.GONE;

public class Recycle_Home extends RecyclerView.Adapter<Recycle_Home.AIO_CARD> {

    private String[] mFst_Btn,mSnd_Btn,mTitle,mSubTitle;
    private @DrawableRes int[] mImage;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
//
    //public static class MyViewHolder extends RecyclerView.ViewHolder {
        //        // each data item is just a string in this case
//        public TextView textView;
//
//        public MyViewHolder(TextView v) {
//            super(v);
//            textView = v;
//        }
//    }
    public class AIO_CARD extends RecyclerView.ViewHolder {

        private Button fst_btn,snd_btn;
        private TextView title,sub_title;
        private ImageView image;

        public AIO_CARD(View view) {
            super(view);
            fst_btn = view.findViewById(R.id.btn_add_to_calendar);
            snd_btn = view.findViewById(R.id.btn_approve);
            title = view.findViewById(R.id.text_title);
            sub_title = view.findViewById(R.id.text_sub_title);
            image = view.findViewById(R.id.header_image);
            image.setVisibility(GONE);
            fst_btn.setVisibility(GONE);
            snd_btn.setVisibility(GONE);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Recycle_Home(String[] title,String[] subtitle,String[] fst_btn,String[] snd_btn,@DrawableRes int[] image) {
        mTitle = title;
        mSubTitle = subtitle;
        mFst_Btn = fst_btn;
        mSnd_Btn = snd_btn;
        mImage = image;
    }

    // Create new views (invoked by the layout manager)
    @Override
    @NonNull
    public AIO_CARD onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.aio_card, parent, false);

        AIO_CARD vh = new AIO_CARD(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull AIO_CARD holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.title.setText(mTitle[position]);
        holder.sub_title.setText(mSubTitle[position]);

        if (mSubTitle[position].equals("")){
            holder.sub_title.setVisibility(GONE);
        }
        else {
            holder.sub_title.setVisibility(View.VISIBLE);
            holder.sub_title.setText(mFst_Btn[position]);
        }

        if (mFst_Btn[position].equals("")){
            holder.fst_btn.setVisibility(GONE);
        }
        else {
            holder.fst_btn.setVisibility(View.VISIBLE);
            holder.fst_btn.setText(mFst_Btn[position]);
        }

        if (mSnd_Btn[position].equals("")){
            holder.snd_btn.setVisibility(GONE);
        }
        else {
            holder.snd_btn.setVisibility(View.VISIBLE);
            holder.snd_btn.setText(mSnd_Btn[position]);
        }

        if (mImage[position]==0){
            holder.image.setVisibility(GONE);
        }
        else {
            holder.image.setVisibility(View.VISIBLE);
            holder.image.setImageResource(mImage[position]);
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mTitle.length;
    }
}