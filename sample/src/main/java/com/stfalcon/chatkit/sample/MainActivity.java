package com.stfalcon.chatkit.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.stfalcon.chatkit.sample.dialogs.DialogsListActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ChatSamplesListAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<ChatSamplesListAdapter.ChatSample> samples = new ArrayList<ChatSamplesListAdapter.ChatSample>() {
            {
                add(new ChatSamplesListAdapter.ChatSample(getString(R.string.sample_title_default),
                        "", R.drawable.bg_preview_default_design, ChatSamplesListAdapter.ChatSample.Type.DEFAULT));
                add(new ChatSamplesListAdapter.ChatSample(getString(R.string.sample_title_attrs),
                        "", R.drawable.bg_preview_attrs_styling, ChatSamplesListAdapter.ChatSample.Type.CUSTOM_ATTR));
                add(new ChatSamplesListAdapter.ChatSample(getString(R.string.sample_title_layout),
                        "", R.drawable.bg_preview_custom_layout, ChatSamplesListAdapter.ChatSample.Type.CUSTOM_LAYOUT));
                add(new ChatSamplesListAdapter.ChatSample(getString(R.string.sample_title_holder),
                        "", R.drawable.bg_preview_custom_holder, ChatSamplesListAdapter.ChatSample.Type.CUSTOM_VIEW_HOLDER));
            }
        };

        ChatSamplesListAdapter adapter = new ChatSamplesListAdapter(samples);
        adapter.setOnItemClickListener(this);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chatSamplesList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClickListener(ChatSamplesListAdapter.ChatSample item) {
        DialogsListActivity.open(this, item.type);
    }
}
