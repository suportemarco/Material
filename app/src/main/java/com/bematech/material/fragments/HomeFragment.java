package com.bematech.material.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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
        rv =  setupRecyclerView(rv);
        return rv;
    }

    private RecyclerView setupRecyclerView(RecyclerView recyclerView) {

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

//        Normal
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());

//       Obrigatorio
        MyRecyclerViewAdapter simpleAdapter = new MyRecyclerViewAdapter(recyclerView, ImageUrlUtils.generateCardModelList());

        //Avocarrot
        String mainId = "07df546f308d05bc19856fba4a61c54be8a0bd56";
        String listId = "6d97136f7cad66fe6a5c7f18613de54b4b9322f0";
        String feedId = "809007991dbbaf8c94a4ed52a7fe27d51962f539";
        String feedId2 = "e8f96319cfd5b1fae47e4ec1a2acc9fe89d82774";
        String custom = "eafbdc223ffe81c19f7eb2c6b20a3cf44b1a9d80";

        AvocarrotInstreamRecyclerView avocarrotInstreamRecyclerView = new AvocarrotInstreamRecyclerView(simpleAdapter, getActivity(), mainId, custom);
        avocarrotInstreamRecyclerView.setSandbox(true);
        avocarrotInstreamRecyclerView.setLogger(true, "ALL");
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        //recyclerView.setPadding(40,0,40,8);
        recyclerView.setPadding(5, 10, 5, 10);

        avocarrotInstreamRecyclerView.setFrequency(3, 3);
        avocarrotInstreamRecyclerView.setLayout(
                R.layout.avo_tile_layout,
                R.id.avo_container,
                R.id.avo_native_headline,
                R.id.avo_native_description,
                0,
                R.id.avo_native_image,
                R.id.avo_cta_button
        );

        recyclerView.setAdapter(avocarrotInstreamRecyclerView);
        return recyclerView;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grid_movie, parent, false);
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
