package rawDeepLearningClassifier.dataSelector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import PamView.dialog.PamDialogPanel;

/**
 * Swing panel for the deep learning data selector. 
 */
public class DLSelectPanel implements PamDialogPanel {

	public DLSelectPanel(DLDataSelector dlDataSelector) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public JComponent getDialogComponent() {
		// TODO Auto-generated method stub
		return new JLabel("Hello Annotation DL");
	}

	@Override
	public void setParams() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getParams() {
		// TODO Auto-generated method stub
		return true;
	}

}
