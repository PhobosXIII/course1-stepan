package e.user.weatherapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClothesAdapter extends RecyclerView.Adapter<ClothesAdapter.ClothesViewHolder> {
    List<Clothes> clothes;

    public ClothesAdapter(List<Clothes> clothes) {
        this.clothes = clothes;
    }

    @NonNull
    @Override
    public ClothesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_clothes, viewGroup, false);
        return new ClothesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothesViewHolder clothesViewHolder, int position) {
        clothesViewHolder.bind(clothes.get(position));
    }

    public void add(Clothes clothes) {
        this.clothes.add(clothes);
        notifyDataSetChanged();
    }

    public void update(List<Clothes> clothes) {
        this.clothes.clear();
        this.clothes.addAll(clothes);
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return clothes == null ? 0 : clothes.size();
    }

    public static class ClothesViewHolder extends RecyclerView.ViewHolder {
         TextView tvName;
         TextView tvTemperature;



        public ClothesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvTemperature = itemView.findViewById(R.id.tvTemperature);

        }

        public void bind(Clothes clothes) {
            tvName.setText(clothes.getClothesName());
            String tempRange = String.format("%d - %d", clothes.getTFrom(), clothes.getTTo());
            tvTemperature.setText(tempRange);
        }
    }
}