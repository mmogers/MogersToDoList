package lv.example.mogerstodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listViewTasks;
    private List<Task> tasks;
    private ToDoList toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks = new ArrayList<Task>(0);
        toDoList = new ToDoList(this);

        listViewTasks = (ListView) findViewById(R.id.listViewTasks);

        populateListViewTasks();

        listViewTasks.setOnItemClickListener(listViewListener);
    }

    public void handleClick(View v) {
        switch (v.getId()){
            case R.id.buttonAddToDo:
                Intent addTask = new Intent(this, EditTaskActivity.class);
                startActivity(addTask);
                break;
        }

    }





























    private void populateListViewTasks(){
        //create a list of strings
        List <String> taskStrings = new ArrayList<String>(0);

        tasks = toDoList.getAllTasks();

        for(int i =0;i<tasks.size();i++){
            taskStrings.add(tasks.get(i).toString());
        }

        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<String >(this, android.R.layout.simple_list_item_1, taskStrings);

        listViewTasks.setAdapter(arrayAdapter);
    }

    private AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

            //Get task ID or selected task
            int taskId = tasks.get(position).getId();
            //make intent
            goToEditTask(taskId);
        }

    };

    protected void goToEditTask(int id){
        Intent editTask = new Intent(this, EditTaskActivity.class);
        editTask.putExtra("lv.example.mogerstodolist.taskId", id);
        startActivity(editTask);
    }


}//end class mainActivity