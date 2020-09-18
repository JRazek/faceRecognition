package jrazek.faces.recognition.netSetup;

import jrazek.faces.recognition.structure.activations.Activation;
import jrazek.faces.recognition.structure.activations.ReLU;
import jrazek.faces.recognition.structure.activations.Sigmoid;
import jrazek.faces.recognition.utils.Utils;

public class NetSettings {
    private final Class<? extends Activation> convolutionActivation = ReLU.class;
    private final Class<? extends Activation> feedForwardActivation = Sigmoid.class;
    private final int convolutionLayers = 5;
    private final int feedForwardLayers = 3;
    private final int neuronsPerLayer = 10;
    private final Utils.Vector2Num<Integer> kernelSize = new Utils.Vector2Num<>(3,3);

    public Class<? extends Activation> getConvolutionActivation() {
        return convolutionActivation;
    }

    public int getFeedForwardLayers() {
        return feedForwardLayers;
    }

    public int getConvolutionLayers() {
        return convolutionLayers;
    }

    public Class<? extends Activation> getFeedForwardActivation() {
        return feedForwardActivation;
    }

    public int getNeuronsPerLayer() {
        return neuronsPerLayer;
    }

    public Utils.Vector2Num<Integer> getKernelSize() {
        return kernelSize;
    }
}