package es.ulpgc.dayron.spotifly.users;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import es.ulpgc.dayron.spotifly.R;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

  private final View.OnClickListener clickListener;
  public static String TAG = UsersAdapter.class.getSimpleName();
  private List<String> usersItemList;

  public UsersAdapter(View.OnClickListener listener) {
    usersItemList = new ArrayList<>();
    clickListener = listener;
  }

  public void setItems(List<String> items) {
    usersItemList = items;
    Log.d("AdapterU1", usersItemList.toString());
    notifyDataSetChanged();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    final TextView userView;

    ViewHolder(View view) {
      super(view);
      userView = view.findViewById(R.id.textViewUser);

    }
  }

  @Override
  public int getItemCount() {
    Log.d("AdapterU2", String.valueOf(usersItemList.size()));
    return usersItemList.size();
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_content, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    holder.itemView.setTag(usersItemList.get(position));
    holder.itemView.setOnClickListener(clickListener);
    Log.d("AdapterU3", usersItemList.get(position));
    holder.userView.setText(usersItemList.get(position));
  }


}
