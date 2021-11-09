package testproject.aaamab.mvpapp.ui.chats;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import testproject.aaamab.mvpapp.R;
import testproject.aaamab.mvpapp.ui.adapters.ChatsAdapter;

public class ChatsScreen extends AppCompatActivity {

    RecyclerView chatsRec ;
    ChatsAdapter adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_screen);
        chatsRec = findViewById(R.id.recChats);
        adapter = new ChatsAdapter(this);
        chatsRec.setLayoutManager(new LinearLayoutManager(this));
        chatsRec.setAdapter(adapter);
    }
}