package uk.ac.aston.paskannm.pockettraveler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.Place;
import uk.ac.aston.paskannm.pockettraveler.R;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private List<Place> placeList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView placeTitle, placeDate;
        public ImageView avatarImage, thumbnailImage;
        public Button viewButton, editButton;

        public ViewHolder(View v) {
            super(v);
            this.placeTitle = (TextView) v.findViewById(R.id.title);
            this.placeDate = (TextView) v.findViewById(R.id.date);
            this.avatarImage = (ImageView) v.findViewById(R.id.avatar_image);
            this.thumbnailImage = (ImageView) v.findViewById(R.id.thumbnail);
            this.viewButton = (Button) v.findViewById(R.id.view_button);
            this.editButton = (Button) v.findViewById(R.id.edit_button);
        }
    }

    public PlaceAdapter(List<Place> placeList) {
        this.placeList = placeList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.template_cardview, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder holder, int position) {
        Place place = placeList.get(position);
        holder.editButton.setText("EDIT");
        holder.viewButton.setText("VIEW");
        holder.placeTitle.setText(String.valueOf(place.getTitle()));
        holder.placeDate.setText(String.valueOf(place.getDate()));
        holder.thumbnailImage.setImageResource(place.getThumbnail());
        holder.avatarImage.setImageResource(R.color.colorPrimary);
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }
}
