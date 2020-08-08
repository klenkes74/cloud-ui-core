package net.moewes.cloud.ui;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class UiBinder {

  private Supplier<?> getter;
  private Consumer<Object> setter;
  private UiComponent component;

  public void bind(UiComponent component, Supplier<?> getter,
      Consumer<Object> setter) {

    this.getter = getter;
    this.setter = setter;
    this.component = component;
    component.bind(this);
  }

  public void setValue() {

    if (getter!=null) {
      Object o = getter.get();
      component.setValue(o.toString());
    }
  }

  public void getValue() {

    if (setter!=null) {
      setter.accept(component.getValue());
    }
  }
}
