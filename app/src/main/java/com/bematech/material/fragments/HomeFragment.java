package com.bematech.material.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.avocarrot.androidsdk.AvocarrotInstreamRecyclerView;
import com.bematech.material.R;
import com.bematech.material.activities.DetailActivity;
import com.bematech.material.activities.MainActivity;
import com.bematech.material.models.CardModel;
import com.bematech.material.models.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;


/**
 * Created by c1401895 on 01/07/2015.
 */
public class HomeFragment extends Fragment {

    private static MainActivity mActivity;

   public static ArrayList<CardModel> myCardModelArrayList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (MainActivity) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RecyclerView rv = (RecyclerView) inflater.inflate(R.layout.fragment_home, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

        //NAO APAGAR
//        if (ImageListFragment.this.getArguments().getInt("type") == 1) {
//            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
//        } else if (ImageListFragment.this.getArguments().getInt("type") == 2) {
//            StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//            recyclerView.setLayoutManager(layoutManager);
//        } else {
//            GridLayoutManager layoutManager = new GridLayoutManager(recyclerView.getContext(), 3);
//            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//            recyclerView.setLayoutManager(layoutManager);
//        }


//        Grid
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //recyclerView.setLayoutManager(layoutManager);

//        Normal
//        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));


//       Obrigatorio
//        SimpleStringRecyclerViewAdapter simpleAdapter = new SimpleStringRecyclerViewAdapter(recyclerView, ImageUrlUtils.createCustomBeacon("Relacionamento", 20));
        MyRecyclerViewAdapter simpleAdapter = new MyRecyclerViewAdapter(recyclerView, ImageUrlUtils.generateCardModelList());
        //recyclerView.setAdapter(simpleAdapter);

        //Testar
        AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new AvocarrotInstreamRecyclerView(simpleAdapter, getActivity(), "07df546f308d05bc19856fba4a61c54be8a0bd56", "809007991dbbaf8c94a4ed52a7fe27d51962f539");
        // Configure AvocarrotInstreamRecyclerView
        avocarrotInstreamRecyclerView.setSandbox(true);
        avocarrotInstreamRecyclerView.setLogger(true, "ALL");
        // Activate AvocarrotInstreamRecyclerView
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(avocarrotInstreamRecyclerView);
    }

    public static class MyRecyclerViewAdapter
            extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

        private RecyclerView mRecyclerView;
        private ArrayList<CardModel> cardModelArrayList = new ArrayList<>();

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final SimpleDraweeView mImageView;

            public ViewHolder(View view) {
                super(view);
                mView = view;

                mImageView = (SimpleDraweeView) view.findViewById(R.id.image1);

            }
        }

        public MyRecyclerViewAdapter(RecyclerView recyclerView, ArrayList<CardModel> cardModelArrayList) {
            this.cardModelArrayList = cardModelArrayList;
            mRecyclerView = recyclerView;
            HomeFragment.myCardModelArrayList = cardModelArrayList;

          }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grid, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {

//            NAO APAGAR
            //FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) holder.mImageView.getLayoutParams();
            if (mRecyclerView.getLayoutManager() instanceof GridLayoutManager) {
                //layoutParams.height = 200;
            } else if (mRecyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                //layoutParams.height = 600;
                //layoutParams.height = 450;
            } else {
                //layoutParams.height = 800;
            }

            Uri uri = Uri.parse(cardModelArrayList.get(position).getImageUrl());
            holder.mImageView.setImageURI(uri);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();

                    Toast.makeText(context, "Posição " + String.valueOf(position), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(DetailActivity.EXTRA_POSITION, position);
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public int getItemCount() {
            return cardModelArrayList.size();
        }
    }


}
