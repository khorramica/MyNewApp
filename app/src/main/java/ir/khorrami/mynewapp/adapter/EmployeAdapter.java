package ir.khorrami.mynewapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.khorrami.mynewapp.R;
import ir.khorrami.mynewapp.model.Employee;

public class EmployeAdapter extends RecyclerView.Adapter<EmployeAdapter.MyViewHolder> {

    Context context;
    List<Employee> data;

    public EmployeAdapter(Context context, List<Employee> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName.setText(data.get(position).getEmployeeName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.text_Name);
        }
    }
}
