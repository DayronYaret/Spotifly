package es.ulpgc.dayron.spotifly.songs;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.dayron.spotifly.R;
import es.ulpgc.dayron.spotifly.app.Song;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

  private final View.OnClickListener clickListener;
  public static String TAG = SongsAdapter.class.getSimpleName();
  private List<String> songsItemList;

  public SongsAdapter(View.OnClickListener listener) {
    songsItemList = new ArrayList<>();
    clickListener = listener;
  }

  public void setItems(List<String> items) {
    songsItemList = items;
    Log.d("Adapter", songsItemList.toString());
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView titleView;

    ViewHolder(View view) {
      super(view);
      titleView = view.findViewById(R.id.textViewTitleContent);

    }
  }

  @Override
  public int getItemCount() {
    Log.d("Adapter3", String.valueOf(songsItemList.size()));
    return songsItemList.size();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    holder.itemView.setTag(songsItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    Log.d("Adapter2", songsItemList.get(position));
    holder.titleView.setText(songsItemList.get(position));
  }


}
