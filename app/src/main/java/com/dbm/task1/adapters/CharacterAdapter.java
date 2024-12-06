package com.dbm.task1.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dbm.task1.models.Character;
import com.dbm.task1.R;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private Context context;
    private List<Character> characters;
    private List<Character> fullList;
    public CharacterAdapter(Context context, List<Character> characters) {
        this.context = context;
        this.characters = characters;
        this.fullList = new ArrayList<>(characters);
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, description;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.character_image);
            name = itemView.findViewById(R.id.character_name);
            description = itemView.findViewById(R.id.character_description);
        }
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        Glide.with(context)
                .load(character.getImageResId())
                .apply(RequestOptions.circleCropTransform()
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .override(100, 100))
                .into(holder.image);

        holder.name.setText(character.getName());
        holder.description.setText(character.getDescription());

        holder.itemView.setOnClickListener(v ->
                Toast.makeText(context, "לחצת על: " + character.getName(), Toast.LENGTH_SHORT).show()
        );
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public void filter(String query) {
        characters.clear();
        if (query.isEmpty()) {
            characters.addAll(fullList);
        } else {
            for (Character character : fullList) {
                if (character.getName().toLowerCase().contains(query.toLowerCase())) {
                    characters.add(character);
                }
            }
        }
        notifyDataSetChanged();
    }
}
