package com.gg.ml;

import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.CSVLoader;

import java.io.File;

public class convertFiles {

    public static void main(String args[]) throws Exception
    {
        //Convert("/dataSource/countries_of_the_world.csv", "/dataDest/countries_of_the_world.arff");
        CSVLoader loader = new CSVLoader();
        loader.setSource(new File("src/com/gg/ml/dataSource/Future50.csv"));
        Instances data = loader.getDataSet();
        ArffSaver saver = new ArffSaver();
        saver.setInstances(data);
        saver.setFile(new File("src/com/gg/ml/dataDest/Future50.arff"));
        saver.writeBatch();
    }
    
}
