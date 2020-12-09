package com.example.context_menu.context_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;

import com.example.context_menu.R;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView pressView = (TextView) findViewById(R.id.press);
        registerForContextMenu(pressView);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.open:
                Opens();
                return true;
            case R.id.exit:
                Exits();
                return true;
            case R.id.refresh:
                Refresh();
                return true;
            case R.id.delete:
                Delete();
                return true;
            default:
                return false;
        }
    }

    private void Opens() {
        Toast.makeText(this, "Opened", Toast.LENGTH_LONG).show();
    }

    private void Exits() {
        Toast.makeText(this, "Exited", Toast.LENGTH_LONG).show();
    }

    private void Delete() {
        Toast.makeText(this, "Deleted", Toast.LENGTH_LONG).show();
    }

    private void Refresh() {
        Toast.makeText(this, "Refreshed", Toast.LENGTH_LONG).show();
    }
}