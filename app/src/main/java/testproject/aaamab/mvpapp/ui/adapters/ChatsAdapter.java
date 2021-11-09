package testproject.aaamab.mvpapp.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import testproject.aaamab.mvpapp.R;
import testproject.aaamab.mvpapp.ui.profile.ProfileScreen;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.MyViewHolder> {

    String [] name = {"Ahmed Ashraf","Mohamed Khaled","Youssif ismail","AbdElrahman Ashraf"};
    String [] email = { "aaamab@gmail.com" ,"mk@gmail.com" , "yi@gmail.com" , "ash@gmail.com"};
    Context context ;

    public ChatsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ChatsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate( R.layout.item_style,parent ,false);
        return new ChatsAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatsAdapter.MyViewHolder holder, int position) {
        holder.name.setText(name[position]);
        holder.email.setText(email[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToProfile = new Intent(context , ProfileScreen.class);
                goToProfile.putExtra("name" , name[position]);
                goToProfile.putExtra("email" , email[position]);
                context.startActivity(goToProfile);
            }
        });
    }

    @Override
    public int getItemCount() {
        return email.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name , email ;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            email  = itemView.findViewById(R.id.txtEmail);
        }
    }
}
