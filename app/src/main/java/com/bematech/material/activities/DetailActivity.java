package com.bematech.material.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.bematech.material.R;
import com.bematech.material.fragments.HomeFragment;
import com.bematech.material.models.ImageUrlUtils;
import com.facebook.drawee.view.SimpleDraweeView;



/**
 * Created by c1401895 on 03/07/2015.
 */
public class DetailActivity  extends AppCompatActivity {

    public static final String EXTRA_POSITION = "position";
    String position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        position = intent.getExtras().get(EXTRA_POSITION).toString();


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        String title = HomeFragment.myCardModelArrayList.get(Integer.parseInt(position)).getTitle();
        collapsingToolbar.setTitle(title);

        loadBackdrop();
    }

    private void loadBackdrop() {
//        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
//        Glide.with(this).load(Cheeses.getRandomCheeseDrawable()).centerCrop().into(imageView);

//        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/fresco-logo.png");
        Uri uri = Uri.parse( ImageUrlUtils.getImageUrlList().get(Integer.parseInt(position)));
        SimpleDraweeView imageView = (SimpleDraweeView) findViewById(R.id.backdrop);
        imageView.setImageURI(uri);

        ImageUrlUtils.getImageUrlList().get(Integer.parseInt(position));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
