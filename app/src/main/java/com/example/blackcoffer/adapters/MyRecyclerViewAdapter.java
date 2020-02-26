package com.example.blackcoffer.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blackcoffer.Folder;
import com.example.blackcoffer.FolderFragment;
import com.example.blackcoffer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<Folder> folders;
    private View mView;


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
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.set_Name.setText(folders.get(position).getFolderName());
        holder.set_Disc.setText(folders.get(position).getFolderDisc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new FolderFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.master_layout, myFragment).addToBackStack(null).commit();
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
        //private final View mView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            set_Name = itemView.findViewById(R.id.folder_name);
            set_Disc = itemView.findViewById(R.id.folder_disc);

        }

        @Override
        public void onClick(View view) {
        mOnClickListener.onEntryClick(view);
        }
    }
    private onClickListener mOnClickListener;

    public interface onClickListener{
        void onEntryClick(View view);
    }

    public void setOnClickListener(onClickListener onClickListener){
        mOnClickListener = onClickListener;
    }
}
