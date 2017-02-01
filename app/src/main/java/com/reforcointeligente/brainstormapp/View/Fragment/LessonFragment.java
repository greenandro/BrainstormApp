package com.reforcointeligente.brainstormapp.View.Fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import com.reforcointeligente.brainstormapp.Controller.FirebaseUtils;
import com.reforcointeligente.brainstormapp.R;
import com.reforcointeligente.brainstormapp.View.Forms.LessonFormActivity;

public class LessonFragment extends Fragment{
    private ListView listLesson;

    public LessonFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.lesson_fragment, container, false);
        setHasOptionsMenu(true);

        listLesson = (ListView) rootView.findViewById(R.id.list_lesson);

        Button newLessonButton = (Button) rootView.findViewById(R.id.list_new_lesson);
        newLessonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lessonFormActivity = new Intent(getActivity(), LessonFormActivity.class);
                getActivity().startActivity(lessonFormActivity);
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        // loading list of lessons
        listLesson.setAdapter(FirebaseUtils.loadLessons(getActivity()));
    }

    public static LessonFragment newInstance() {
        return new LessonFragment();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_lesson_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_order_lesson_by_creation:
                listLesson.setAdapter(FirebaseUtils.loadLessons(getActivity()));
                break;
            case R.id.item_order_lesson_by_date:
                listLesson.setAdapter(FirebaseUtils.orderListOfLessonsByDate(getActivity()));
                break;
            case R.id.item_order_lesson_by_student_name:
                listLesson.setAdapter(FirebaseUtils.orderListOfLessonsByStudentName(getActivity()));
                break;
            case R.id.item_order_lesson_by_teacher_name:
                listLesson.setAdapter(FirebaseUtils.orderListOfLessonsByTeacherName(getActivity()));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
