package com.bs.test;

/**
 * @author Huang
 * @date 2018-03-25 22:54
 * @desc
 */
public class Dog {


    private String name;

    private String say;

    public Dog(String name, String say) {
        this.name = name;
        this.say = say;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

//    @Override
//    public String toString() {
//        return "Dog{" +
//                "name='" + name + '\'' +
//                ", say='" + say + '\'' +
//                '}';
//    }

    public static void main(String[] args) {

        Dog dog1 = new Dog("spot", "Ruff!");
        Dog dog2 = new Dog("scruffy", "Wurf!");

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());

        Dog dog3 = new Dog("spot","Ruff!");
        System.out.println(dog3);
        System.out.println(dog1==dog3);
        System.out.println(dog1.equals(dog3));

    }

}
