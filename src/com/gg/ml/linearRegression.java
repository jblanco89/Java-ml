package com.gg.ml;

import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;

public class linearRegression{
	public static void main(String args[]) throws Exception{
		//Load Data set
		DataSource srcTrain = new DataSource("src/com/gg/ml/dataDest/sleep.arff");
		Instances train = srcTrain.getDataSet();
		//set class index to the last attribute
		train.setClassIndex(2);
		
		//Build model
		LinearRegression model = new LinearRegression();
		model.buildClassifier(train);
		//output model

		Evaluation eval = new Evaluation(train);
		eval.evaluateModel(model, train);


		System.out.println("LR FORMULA : "+model);
		System.out.println("** Linear Regression Evaluation with Datasets **");
		System.out.println(eval.toSummaryString());	
		
		// Now Predicting the max_life_span
		
		//Load Data set
		DataSource srcTest = new DataSource("src/com/gg/ml/dataDest/sleepTest.arff");
		Instances test = srcTest.getDataSet();
		//Instance lifeSpan = test.lastInstance();

		for (int i=0;i<test.numInstances();i++){
			Instance lifeSpan = test.instance(i);
			double maxLifeSpan = model.classifyInstance(lifeSpan);
			System.out.println("PREDICTED AGE : "+maxLifeSpan);

		}
			
	}
}