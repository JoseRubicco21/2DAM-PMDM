package com.tareas.imccalculator;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ResultIMCFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ResultIMCFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ResultIMCFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ResultIMCFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ResultIMCFragmentArgs __result = new ResultIMCFragmentArgs();
    bundle.setClassLoader(ResultIMCFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("result")) {
      float result;
      result = bundle.getFloat("result");
      __result.arguments.put("result", result);
    } else {
      throw new IllegalArgumentException("Required argument \"result\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ResultIMCFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ResultIMCFragmentArgs __result = new ResultIMCFragmentArgs();
    if (savedStateHandle.contains("result")) {
      float result;
      result = savedStateHandle.get("result");
      __result.arguments.put("result", result);
    } else {
      throw new IllegalArgumentException("Required argument \"result\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public float getResult() {
    return (float) arguments.get("result");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("result")) {
      float result = (float) arguments.get("result");
      __result.putFloat("result", result);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("result")) {
      float result = (float) arguments.get("result");
      __result.set("result", result);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ResultIMCFragmentArgs that = (ResultIMCFragmentArgs) object;
    if (arguments.containsKey("result") != that.arguments.containsKey("result")) {
      return false;
    }
    if (Float.compare(that.getResult(), getResult()) != 0) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + Float.floatToIntBits(getResult());
    return result;
  }

  @Override
  public String toString() {
    return "ResultIMCFragmentArgs{"
        + "result=" + getResult()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ResultIMCFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(float result) {
      this.arguments.put("result", result);
    }

    @NonNull
    public ResultIMCFragmentArgs build() {
      ResultIMCFragmentArgs result = new ResultIMCFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setResult(float result) {
      this.arguments.put("result", result);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    public float getResult() {
      return (float) arguments.get("result");
    }
  }
}
