package uk.ac.aston.paskannm.pockettraveler.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uk.ac.aston.paskannm.pockettraveler.Holiday;
import uk.ac.aston.paskannm.pockettraveler.R;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.ViewHolder> {

    private List<Holiday> holidayList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView holidayTitle, holidayStart, holidayEnd, holidayNotes;
        public ImageView avatarImage, thumbnailImage;
        public Button viewButton, editButton;

        public ViewHolder(View v) {
            super(v);
            holidayTitle = (TextView) v.findViewById(R.id.title);
            holidayStart = (TextView) v.findViewById(R.id.start);
            holidayEnd = (TextView) v.findViewById(R.id.end);
            holidayNotes = (TextView) v.findViewById(R.id.notes);
            avatarImage = (ImageView) v.findViewById(R.id.avatar_image);
            thumbnailImage = (ImageView) v.findViewById(R.id.thumbnail);
            viewButton = (Button) v.findViewById(R.id.view_button);
            editButton = (Button) v.findViewById(R.id.edit_button);
        }
    }

    public HolidayAdapter(List<Holiday> holidayList) {
        this.holidayList = holidayList;
    }

    @Override
    public HolidayAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_holidays, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HolidayAdapter.ViewHolder holder, int position) {
        Holiday holiday = holidayList.get(position);
        holder.editButton.setText(R.string.button_edit);
        holder.viewButton.setText(R.string.button_view);
        holder.holidayTitle.setText(String.valueOf(holiday.getTitle()));
        holder.holidayStart.append(" " + String.valueOf(holiday.getStartDay()));
        holder.holidayEnd.append(" " + String.valueOf(holiday.getEndDay()));
        holder.holidayNotes.setText(String.valueOf(holiday.getNotes()));
        holder.thumbnailImage.setImageResource(holiday.getThumbnail());
        holder.avatarImage.setImageResource(R.color.colorPrimary);
    }

    @Override
    public int getItemCount() {
        return holidayList.size();
    }
}
