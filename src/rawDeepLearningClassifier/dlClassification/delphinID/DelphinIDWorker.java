package rawDeepLearningClassifier.dlClassification.delphinID;

import rawDeepLearningClassifier.DLControl;
import rawDeepLearningClassifier.dlClassification.animalSpot.StandardModelParams;
import rawDeepLearningClassifier.dlClassification.genericModel.DLModelWorker;

public class DelphinIDWorker extends  DLModelWorker<DelphinIDPrediction>{

	@Override
	public float[] runModel(float[][][] transformedDataStack) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isModelNull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DelphinIDPrediction makeModelResult(float[] prob, double time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepModel(StandardModelParams delphinIDParams, DLControl dlControl) {
		// TODO Auto-generated method stub
	}

	@Override
	public void closeModel() {
		// TODO Auto-generated method stub
		
	}

	

	
}
