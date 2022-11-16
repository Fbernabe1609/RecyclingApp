// Generated by view binder compiler. Do not edit!
package com.example.practica_1_trimestre_multimedia.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.practica_1_trimestre_multimedia.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentEditEmailBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button changeButton;

  @NonNull
  public final EditText editEmailField;

  private FragmentEditEmailBinding(@NonNull ConstraintLayout rootView, @NonNull Button changeButton,
      @NonNull EditText editEmailField) {
    this.rootView = rootView;
    this.changeButton = changeButton;
    this.editEmailField = editEmailField;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentEditEmailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentEditEmailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_edit_email, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentEditEmailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.changeButton;
      Button changeButton = ViewBindings.findChildViewById(rootView, id);
      if (changeButton == null) {
        break missingId;
      }

      id = R.id.editEmailField;
      EditText editEmailField = ViewBindings.findChildViewById(rootView, id);
      if (editEmailField == null) {
        break missingId;
      }

      return new FragmentEditEmailBinding((ConstraintLayout) rootView, changeButton,
          editEmailField);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
