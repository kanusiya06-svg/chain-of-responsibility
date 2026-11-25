/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pattern;

/**
 *
 * @author kanus
 */

interface Command {
    void execute();
}

// Receiver 1
class Light {

    void turnOn() {
        System.out.println("Light is turned ON");
    }

    void turnOff() {
        System.out.println("Light is turned OFF");
    }
}

// Receiver 2
class Fan {

    void turnOn() {
        System.out.println("Fan is running");
    }

    void turnOff() {
        System.out.println("Fan is turned OFF");
    }
}

// Light ON Command
class LightOnCommand implements Command {

    Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

// Light OFF Command
class LightOffCommand implements Command {

    Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Fan ON Command
class FanOnCommand implements Command {

    Fan fan;

    FanOnCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOn();
    }
}

// Fan OFF Command
class FanOffCommand implements Command {

    Fan fan;

    FanOffCommand(Fan fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.turnOff();
    }
}

// Invoker
class RemoteControl {

    Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        System.out.println("Remote Button Pressed");
        command.execute();
    }
}

public class Main4 {

    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        System.out.println();

        remote.setCommand(new FanOnCommand(fan));
        remote.pressButton();

        System.out.println();

        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();

        System.out.println();

        remote.setCommand(new FanOffCommand(fan));
        remote.pressButton();
    }
}
