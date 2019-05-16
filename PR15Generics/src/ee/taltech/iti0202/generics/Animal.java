package ee.taltech.iti0202.generics;

public abstract class Animal {

  protected String name;
  public Animal(String name) {
    this.name = name;
  }

  public abstract void sound();
}
