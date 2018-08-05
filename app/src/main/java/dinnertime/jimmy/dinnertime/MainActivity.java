package dinnertime.jimmy.dinnertime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    //private Button btn_addItem, btn_allItems, btn_allRecipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_addItem = findViewById(R.id.addItem);
        btn_addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddItem();
            }
        });
        Button btn_allItems = findViewById(R.id.items);
        btn_allItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItems();
            }
        });
        Button btn_allRecipes = findViewById(R.id.recipes);
        btn_allRecipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRecipes();
            }
        });
        // Example of a call to a native method
        //TextView tv = (TextView) findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());
    }

    public void openAddItem(){
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }
    public void openItems(){
        Intent intent = new Intent(this, Items.class);
        startActivity(intent);
    }
    public void openRecipes(){
        Intent intent = new Intent(this, Recipes.class);
        startActivity(intent);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
