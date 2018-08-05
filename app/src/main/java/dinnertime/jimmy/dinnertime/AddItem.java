package dinnertime.jimmy.dinnertime;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.RecyclerView;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.AutoCompleteTextView;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class AddItem extends AppCompatActivity {
    private ArrayList<Item> mItemList = null;

    private RecyclerView.Adapter mAdapter;

    private Button buttonInsert, buttonRemove;
    private EditText editTextInsert, editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        String[] items = getResources().getStringArray(R.array.items);
        String[] measurement = getResources().getStringArray(R.array.measurements);

        //Kod för item
        AutoCompleteTextView editTextI = findViewById(R.id.actvAddItem);
        ArrayAdapter<String> IAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);
        editTextI.setAdapter(IAdapter);

        //Kod för mått
        AutoCompleteTextView editTextM = findViewById(R.id.actvAddItemMeasurement);
        ArrayAdapter<String> MAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, measurement);
        editTextM.setAdapter(MAdapter);

        Items tempItems = new Items();
        tempItems.setmItemList(this.mItemList);
        tempItems.setmAdapter(this.mAdapter);

        buttonInsert = findViewById(R.id.addToList);
        buttonRemove = findViewById(R.id.removeFromList);
        editTextInsert = findViewById(R.id.actvAddItemQuantity);
        //editTextRemove = findViewById(R.id.actvAddItemQuantity);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    public void insertItem(int position){
        mItemList.add(position, new Item(R.drawable.ic_android, "New Item at position" + position, "This is line 2"));
        mAdapter.notifyItemInserted(position);
    }
    public void removeItem(int position){
        mItemList.remove(position);
        mAdapter.notifyItemInserted(position);
    }

    private EditText prefItem;
    private EditText prefQuantity;
    private EditText prefMeasurement;
    public void addItemToList(View v){
        prefItem = findViewById(R.id.actvAddItem);
        prefQuantity = findViewById(R.id.actvAddItemQuantity);
        prefMeasurement = findViewById(R.id.actvAddItemMeasurement);
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 0, 0);
        toast.makeText(this, "Adding: " + prefQuantity.getText() + " " + prefMeasurement.getText() + " of " + prefItem.getText(), toast.LENGTH_SHORT).show();
    }
}
