package Array.layoutFX;

import Array.PamArray;
import PamController.PamController;
import PamController.SettingsPane;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import pamViewFX.PamGuiManagerFX;

import pamViewFX.fxNodes.PamVBox;
import pamViewFX.fxNodes.PamBorderPane;

/**
 * The main settings pane for settings up a hydrophone array. 
 * 
 * @author Jamie Macaulay
 * 
 * @param <FlipPane>
 *
 */
public class ArraySettingsPane extends SettingsPane<PamArray >{
	
	/**
	 * Minimum size of the 3D pane.
	 */
	private static final double MIN_3D_WIDTH = 450;

	/**
	 * Minimum height of the 3D pane.
	 */
	private static final double MIN_3D_HEIGHT = 600;

	/**
	 * Pane for adding or removing streamers. 
	 */
	private StreamersPane streamerPane; 
	
	private PamBorderPane mainPane;
	
	/**
	 * Pane for adding or removing hydrophones. 
	 */
	private HydrophonesPane hydrophonePane;

//	private Pane holder;

	private Label hydrophoneLabel;

	/**
	 * Pane which shows a 3D representation of the hydrophone array. 
	 */
	private Array3DPane array3DPane;

	private PropogationPane propogationPane;

	private Label recivierDiagramLabel;

	/**
	 * Pane with controls to change speed of sound. 
	 */
	private SettingsPane<PamArray> environmentalPane; 

	public ArraySettingsPane() {
		super(null);
		mainPane=new PamBorderPane(); 
		
		mainPane.setCenter(createArrayPane());
//		mainPane.setStyle("-fx-background-color: red;");
		mainPane.setMaxWidth(Double.MAX_VALUE);
		mainPane.setMinWidth(1100);
		mainPane.setStyle("-fx-padding: 0,0,0,0");
		
		
		recivierDiagramLabel = new Label("Hydrophone Diagram"); 
		PamGuiManagerFX.titleFont1style(recivierDiagramLabel);
		recivierDiagramLabel.setPadding(new Insets(5,5,5,5));

		Label environmentLabel = new Label("Environment"); 
		PamGuiManagerFX.titleFont1style(environmentLabel);
		environmentLabel.setPadding(new Insets(0,0,5,0)); //little more space under this label
		
		environmentalPane = createEnvironmentPane();
		
		PamVBox rightPane = new PamVBox();
		rightPane.setSpacing(5);
		rightPane.getChildren().addAll(recivierDiagramLabel, create3DPane(), environmentLabel, new PamBorderPane(environmentalPane.getContentNode()));
		VBox.setVgrow(array3DPane, Priority.ALWAYS);
		
		mainPane.setRight(rightPane);
		
//		streamerPane.getStreamerTable().getItems().addListener((ListChangeListener<? super StreamerProperty>) c->{
//			//the streamer table has changed and so the streamer needs changed
//			System.out.println("Streamer Changed!!!");
//		});
		
		streamerPane.addStreamerListener((x,y)->{
			System.out.println("Streamer changed!"); 
			PamArray  array = getParams(new PamArray("temp_array: ", null)) ;
			array3DPane.drawArray(array);
		});
		
		hydrophonePane.addStreamerListener((x,y)->{
			System.out.println("Hydrophone changed!"); 
			PamArray  array = getParams(new PamArray("temp_array: ", null)) ;
			array3DPane.drawArray(array);
		});

//		mainPane.setMinWidth(800);

//		mainPane.setCenter(createArrayPane());
//		
//		mainPane.getAdvPane().setCenter(new Label("Advanced Settings"));
		
		
//		//mainPane.getFront().setStyle("-fx-background-color: grey;");
//		mainPane.setStyle("-fx-background-color: red;");
//		
//		FlipPane aflipPane = new FlipPane(); 
//		aflipPane.setStyle("-fx-background-color: red;");
//		
//		PamHBox stackPane = new PamHBox(); 
//		stackPane.setStyle("-fx-background-color: red;");
//		
//		Button button = new Button(); 
//		button.setOnAction((action)->{
//			System.out.println(" 1 " + stackPane.getPadding());
//			System.out.println(" 2 " +PamBorderPane.getMargin(stackPane));
//			System.out.println(" 3 " + holder.getPadding());
//		});
//		
//		stackPane.getChildren().add(button);
//
//		
//		mainPane.setPadding(new Insets(0,0,0,0));
		
		
//		holder = new StackPane(); 
//		holder.getChildren().add(mainPane);
//		holder.setStyle("-fx-padding: 0,0,0,0");

	}

	private Pane create3DPane() {
		this.array3DPane = new Array3DPane();
		
		//important because the 3D pane has not default size
		array3DPane.setMinWidth(MIN_3D_WIDTH);
		array3DPane.setMinHeight(MIN_3D_HEIGHT);

		return array3DPane;
	}
	
	/**
	 * Create the environment pane. 
	 * @return the environment pane. 
	 */
	private SettingsPane<PamArray> createEnvironmentPane() {
		this.propogationPane = new PropogationPane();
		return propogationPane;
	}

	/**
	 * Create the main pane. 
	 * @return the main array pane. 
	 */
	private Pane createArrayPane() {
		
		Label arrayLabel = new Label("Array"); 
		arrayLabel.setPadding(new Insets(5,5,5,5));
		PamGuiManagerFX.titleFont1style(arrayLabel);
		
		streamerPane = new StreamersPane(); 
		streamerPane.setMaxWidth(Double.MAX_VALUE);
		
		hydrophoneLabel = new Label("Hydrophones"); 
		PamGuiManagerFX.titleFont1style(hydrophoneLabel);
		hydrophoneLabel.setPadding(new Insets(5,5,5,5));
		
		hydrophonePane = new HydrophonesPane(); 
		hydrophonePane.setMaxWidth(Double.MAX_VALUE);

//		PamButton advancedButton = new PamButton(); 
//		advancedButton.setOnAction((action)->{
//			mainPane.flipToBack();
//		});
//		advancedButton.setGraphic(PamGlyphDude.createPamIcon("mdi2c-cog")); 

//		PamHBox advancedPane = new PamHBox(); 
//		advancedPane.setSpacing(5);
//		advancedPane.setAlignment(Pos.CENTER_RIGHT);
//		advancedPane.getChildren().addAll(new Label("Advanced"), advancedButton);
		
		PamVBox vBox = new PamVBox(); 
		vBox.setSpacing(5);
		vBox.getChildren().addAll(arrayLabel, streamerPane, hydrophoneLabel,
				hydrophonePane); 

		return vBox; 
	}
	
	/**
	 * Set correct text for the receiver in the current medium (e.g. air or water); 
	 */
	private void setReceieverLabels() {
		hydrophonePane.setRecieverLabels();
		streamerPane.setRecieverLabels();
		
		hydrophoneLabel.setText(PamController.getInstance().getGlobalMediumManager().getRecieverString(true) + "s");
		recivierDiagramLabel.setText(PamController.getInstance().getGlobalMediumManager().getRecieverString(true) + " diagram"); 
//		if (singleInstance!=null) {
//			singleInstance.setTitle("Pamguard "+ PamController.getInstance().getGlobalMediumManager().getRecieverString(false) +" array");
//		}
	}
	
	
	@Override
	public PamArray  getParams(PamArray  currParams) {
		currParams = hydrophonePane.getParams(currParams); 
		currParams = streamerPane.getParams(currParams); 
		currParams = environmentalPane.getParams(currParams);
//		System.out.println("Array settings pane: No. streamers: " + currParams.getStreamerCount());
		return currParams;
	}

	@Override
	public void setParams(PamArray  input) {
//		System.out.println("Hydrophone array is: "+ input); 
		setReceieverLabels();
		hydrophonePane.setParams(input); 
		streamerPane.setParams(input); 
		environmentalPane.setParams(input);
	}

	@Override
	public String getName() {
		return "Array Parameters";
	}

	@Override
	public Node getContentNode() {

		return mainPane;
	}

	@Override
	public void paneInitialized() {
		// TODO Auto-generated method stub
		
	}

}
