package com.tareas.imccalculator;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class IMCCalculatorFragmentDirections {
  private IMCCalculatorFragmentDirections() {
  }

  @NonNull
  public static ActionIMCCalculatorFragmentToResultIMCFragment actionIMCCalculatorFragmentToResultIMCFragment(
      float result) {
    return new ActionIMCCalculatorFragmentToResultIMCFragment(result);
  }

  public static class ActionIMCCalculatorFragmentToResultIMCFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionIMCCalculatorFragmentToResultIMCFragment(float result) {
      this.arguments.put("result", result);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionIMCCalculatorFragmentToResultIMCFragment setResult(float result) {
      this.arguments.put("result", result);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("result")) {
        float result = (float) arguments.get("result");
        __result.putFloat("result", result);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_IMCCalculatorFragment_to_resultIMCFragment;
    }

    @SuppressWarnings("unchecked")
    public float getResult() {
      return (float) arguments.get("result");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionIMCCalculatorFragmentToResultIMCFragment that = (ActionIMCCalculatorFragmentToResultIMCFragment) object;
      if (arguments.containsKey("result") != that.arguments.containsKey("result")) {
        return false;
      }
      if (Float.compare(that.getResult(), getResult()) != 0) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + Float.floatToIntBits(getResult());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionIMCCalculatorFragmentToResultIMCFragment(actionId=" + getActionId() + "){"
          + "result=" + getResult()
          + "}";
    }
  }
}
