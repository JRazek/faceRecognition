package jrazek.faces.recognition.structure.neural.convolutional;

import jrazek.faces.recognition.Rules;
import jrazek.faces.recognition.structure.Layer;
import jrazek.faces.recognition.structure.neural.Neuron;
import jrazek.faces.recognition.structure.neural.convolutional.interfaces.ConvolutionNetLayer;
import jrazek.faces.recognition.structure.neural.functional.PoolingLayer;
import jrazek.faces.recognition.utils.Utils;

import javax.management.RuntimeErrorException;

public class ConvolutionNeuron extends Neuron {
    private final Utils.Vector3Num<Integer> size;
    private Utils.Matrix3D weights;


    public ConvolutionNeuron(Layer l, int indexInLayer, Utils.Vector3Num<Integer> size) throws RuntimeErrorException {
        super(l, indexInLayer, Rules.convolutionActivation);
        if ((size.getX() / 2) * 2 == size.getX() || (size.getY() / 2) * 2 == size.getY() || !size.getX().equals(size.getY()))
            throw new RuntimeErrorException(new Error("the Kernel size must be odd number!"));
        this.size = size;
        weights = new Utils.Matrix3D(size);
    }

    void initRandomWeights() {
        for (int z = 0; z < size.getZ(); z++) {
            for (int x = 0; x < size.getX(); x++) {
                for (int y = 0; y < size.getY(); y++) {
                    double randomValue  = Utils.randomDouble(-1,1);
                    weights.set(new Utils.Vector3Num<>(x, y, z), randomValue);
                }
            }
        }
    }

    Double getWeight(Utils.Vector3Num<Integer> c) throws RuntimeErrorException {
    return weights.getValue(c);
    }

    @Override
    public void run() {
        Layer prev = getLayer().getNet().getLayers().get(getLayer().getIndexInNet() - 1);
        if (prev instanceof ConvolutionalLayer || prev instanceof PoolingLayer) {
            //convolution happens here//todo

            ((ConvolutionNetLayer) prev).getOutputBox();//List of matrices

        } else {
            //if taking from feed forward layer. not supported in first versions or sure
        }
    }
}