package com.shisheo.mvvm_users.view.activity;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.shisheo.mvvm_users.R;
import com.shisheo.mvvm_users.databinding.ActivityUserDetailBinding;
import com.shisheo.mvvm_users.model.User;
import com.shisheo.mvvm_users.viewModel.UserDetailViewModel;

public class UserDetailActivity extends AppCompatActivity {


    private static final String EXTRA_USER = "EXTRA_USER";

    private ActivityUserDetailBinding activityUserDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);
        setSupportActionBar(activityUserDetailBinding.toolbar);
        displayHomeAsUpEnabled();
        getExtrasFromIntent();
    }

    private void displayHomeAsUpEnabled() {

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public static Intent fillDetail(Context context, User user) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(EXTRA_USER, user);
        return intent;
    }

    private void getExtrasFromIntent(){
        User user = (User) getIntent().getSerializableExtra(EXTRA_USER);
        UserDetailViewModel userDetailViewModel = new UserDetailViewModel(user);
        activityUserDetailBinding.setUserDetailViewModel(userDetailViewModel);
        setTitle(user.name.title + "." + user.name.first + " " + user.name.last);
    }




}
