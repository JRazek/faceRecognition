package jrazek.faces.recognition;

import jrazek.faces.recognition.backpropagation.BackpropagationModule;
import jrazek.faces.recognition.netSetup.NetSettings;
import jrazek.faces.recognition.structure.Net;
import jrazek.faces.recognition.utils.Utils;

public class Main {
    public static void main(String[] args) {
        Net net = new Net(new NetSettings());
        net.randomInit();
        net.forwardPass(new Utils.Matrix3D(new Utils.Vector3Num<>(1,1,1)));
        net.showResultBox();
        /*for(int i = 0; i < 100; i ++){
            System.out.println(Utils.randomDouble(-10,10));
        }*/
        System.out.println("OK");
    }
}
