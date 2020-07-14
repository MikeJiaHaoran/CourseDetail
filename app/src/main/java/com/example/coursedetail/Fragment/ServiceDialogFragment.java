package com.example.coursedetail.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.coursedetail.Adapter.CSDAdapter;
import com.example.coursedetail.R;
import java.util.Objects;

public class ServiceDialogFragment extends DialogFragment {
    private Context context;
    private String[] content;

      public ServiceDialogFragment(Context context, String[] content) {
          this.context = context;
          this.content = content;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void onStart() {
        super.onStart();

        Window window = Objects.requireNonNull(getDialog()).getWindow();
        assert window != null;
        WindowManager.LayoutParams params = window.getAttributes();
        params.gravity = Gravity.BOTTOM;
        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        params.height = Integer.parseInt(content[0]) > 4 ? 1600 : 800;
        window.setAttributes(params);
        //int color = ContextCompat.getColor(Objects.requireNonNull(getActivity()), android.R.color.white);
        //window.setBackgroundDrawable(new ColorDrawable(color));
        Objects.requireNonNull(getDialog().getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setWindowAnimations(R.style.dialog_animation);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        Objects.requireNonNull(getDialog()).requestWindowFeature(Window.FEATURE_NO_TITLE); // 不显示标题栏

        View dialogView = inflater.inflate(R.layout.service_detail, container, false);
        ImageView CourseServiceBack = dialogView.findViewById(R.id.im_Course_Service_Back);
        CourseServiceBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                ServiceDialogFragment.this.dismiss();
            }
        });
        RecyclerView recyclerView = dialogView.findViewById(R.id.rv_Course_Service_Detail);
        recyclerView.setBackgroundResource(R.drawable.shape_corners_dialog_service);
        CSDAdapter csdAdapter = new CSDAdapter(content, context);
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(csdAdapter);

        return dialogView;
    }


}
