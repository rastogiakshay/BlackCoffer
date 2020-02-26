package com.example.blackcoffer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffer.Folder;
import com.example.blackcoffer.FolderFragment;
import com.example.blackcoffer.R;

import java.util.ArrayList;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private onClickListener mOnClickListener;
    private List<Folder> folders;
    private FragmentTransaction fragmentTransaction;
    private String tempString;



    public MyRecyclerViewAdapter() {
        folders = new ArrayList<>();
        folders.add(new Folder("FolderOne","folder"));
        folders.add(new Folder("FolderTwo","folder"));
        folders.add(new Folder("FolderThree","folder"));
        folders.add(new Folder("FolderFour","folder"));
        folders.add(new Folder("FolderFive","folder"));
        folders.add(new Folder("FolderSix","folder"));
        folders.add(new Folder("FolderSeven","folder"));
        folders.add(new Folder("FolderEight","folder"));
        folders.add(new Folder("FolderNine","folder"));
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRecyclerViewAdapter.ViewHolder holder, int position) {

        holder.set_Name.setText(folders.get(position).getFolderName());
        holder.set_Disc.setText(folders.get(position).getFolderDisc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            TextView set_frag_text;
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                //tempString = folders.get(new onClickListener{void onEntryclick()} .getFolderName());
                Fragment myFragment = new FolderFragment(tempString);
                fragmentTransaction = activity.getSupportFragmentManager().beginTransaction().replace(R.id.master_layout, myFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private final TextView set_Name;
        private final TextView set_Disc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            set_Name = itemView.findViewById(R.id.folder_name);
            set_Disc = itemView.findViewById(R.id.folder_disc);


        }

        @Override
        public void onClick(View view) {
        mOnClickListener.onEntryClick(getLayoutPosition());
        tempString = folders.get(getLayoutPosition()).getFolderName();
        }
    }


    public interface onClickListener{
        void onEntryClick(int position);
    }
}
