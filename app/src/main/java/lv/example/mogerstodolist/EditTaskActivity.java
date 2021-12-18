package lv.example.mogerstodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class EditTaskActivity extends AppCompatActivity {
    private ToDoList toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        toDoList = new ToDoList(this);

        //Get order information from the PurchaseActivity
        Intent intent = getIntent();
        int taskId = intent.getIntExtra("lv.example.mogerstodolist.taskId", 0);
        if(taskId != 0){
            populateTaskData(taskId);
        }

    }

    private void populateTaskData(int taskId){
        //Bind to UI Fields
        TextView textId = (TextView) findViewById(R.id.textID);
        CheckBox checkPriority = (CheckBox) findViewById(R.id.checkBoxPriority);
        EditText editDate = (EditText) findViewById(R.id.editDueDate);
        EditText editTask = (EditText) findViewById(R.id.editTask);
        CheckBox checkBoxDone = (CheckBox) findViewById(R.id.checkBoxDone);

        //create task
        Task t = toDoList.getTask(taskId);

        //display data
        textId.setText(String.valueOf(t.getId()));
        checkPriority.setChecked(t.getPriority());
        editDate.setText(t.getDate());
        editTask.setText(t.getTaskDetails());
        checkBoxDone.setChecked(t.getCompleted());

    }

//handle button clicks
    public void handleClick(View v) {
        switch (v.getId()){
            case R.id.buttonAddTask:
                addToDo();
                break;
            case R.id.buttonEditTask:
                editTaskData();
                break;
            case R.id.buttonDeleteTask:
                deleteTask();
                break;
            case R.id.buttonMainMenu:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

        }

    }

    private void editTaskData(){

        //bind to UI Fields
        TextView textID = (TextView) findViewById(R.id.textID);
        CheckBox checkPriority = (CheckBox) findViewById(R.id.checkBoxPriority);
        EditText editDate = (EditText) findViewById(R.id.editDueDate);
        EditText editTask = (EditText) findViewById(R.id.editTask);
        CheckBox checkBoxDone = (CheckBox) findViewById(R.id.checkBoxDone);

        //check if box has data
        if(textID.getText().toString().length() > 0){
            int id = Integer.valueOf(textID.getText().toString());
            Task t = toDoList.getTask(id);

            t.setPriority(checkPriority.isChecked());
            t.setDate(editDate.getText().toString());
            t.setTask(editTask.getText().toString());
            t.setCompleted(checkBoxDone.isChecked());

            toDoList.editTask(t);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


    }

    private void addToDo(){
        //Bind to UI Fields
        TextView textID = (TextView) findViewById(R.id.textID);
        CheckBox checkPriority = (CheckBox) findViewById(R.id.checkBoxPriority);
        EditText editDate = (EditText) findViewById(R.id.editDueDate);
        EditText editTask = (EditText) findViewById(R.id.editTask);
        CheckBox checkBoxDone = (CheckBox) findViewById(R.id.checkBoxDone);

        Task t = new Task();

        //Handle Date data
        t.setPriority(checkPriority.isChecked());
        t.setDate(editDate.getText().toString());
        t.setTask(editTask.getText().toString());
        t.setCompleted(checkBoxDone.isChecked());

        Task newTask = toDoList.createTask(t);

        //display the id of the task
        textID.setText(String.valueOf(newTask.getId()));
        //textID.setText("Test");

    }

    private void deleteTask(){
        //bind to UI fields
        TextView textID = (TextView) findViewById(R.id.textID);

        //check if box has data
        if(textID.getText().toString().length() > 0){
            int id = Integer.valueOf(textID.getText().toString());
            Task t = toDoList.getTask(id);
            toDoList.deleteTask(t);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }

}//end class