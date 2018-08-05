package dinnertime.jimmy.dinnertime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Items extends AppCompatActivity {
    private ArrayList<Item> mItemList;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        createItemList();
        buildRecyclerView();

    }
    public void setmItemList(ArrayList mItemList){
        this.mItemList = mItemList;
    }
    public ArrayList getItemList(){
        return mItemList;
    }
    public void setmAdapter(RecyclerView.Adapter mAdapter){
        this.mAdapter = mAdapter;
    }
    public RecyclerView.Adapter getmAdapter(){
        return mAdapter;
    }

    public void createItemList(){
        mItemList = new ArrayList<>();
        mItemList.add(new Item(R.drawable.ic_android, "Line 1", "Line 2"));
        mItemList.add(new Item(R.drawable.ic_cake, "Line 3", "Line 4"));
        mItemList.add(new Item(R.drawable.ic_camera, "Line 5", "Line 6"));
    }
    public void buildRecyclerView(){
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ItemAdapter(mItemList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
