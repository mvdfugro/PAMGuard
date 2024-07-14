package rawDeepLearningClassifier.dataSelector;

import PamguardMVC.PamDataUnit;
import PamguardMVC.dataSelector.DataSelectParams;
import pamViewFX.fxSettingsPanes.DynamicSettingsPane;

/**
 * Score a data unit with a deep learning annotation. Note that this could be an
 * external data unit with an annotation e.g. a click, or deep learning
 * detections generated by the deep learning module.
 * 
 * @author Jamie Macaulay
 */
public interface DLDataFilter {
	
	/**
	 * Score a data unit with deep learning annotations 
	 * @param dataUnit - the data unit to score
	 * @return 0 to reject and >0 to accept. 
	 */
	public int scoreDLData(PamDataUnit dataUnit);
	
	/**
	 * Get parameters for the data filter. 
	 * @return parameters for the data selectors. 
	 */
	public DataSelectParams getParams(); 
	
	/**
	 * Set the parameters for the data filter. 
	 * @param params - the parameters to set. 
	 */
	public void setParams(DataSelectParams params); 
	
	/**
	 * Settings controls for this filter. 
	 * @return the cotnrols for this filter. 
	 */
	public DynamicSettingsPane<DataSelectParams> getSettingsPane();


}
