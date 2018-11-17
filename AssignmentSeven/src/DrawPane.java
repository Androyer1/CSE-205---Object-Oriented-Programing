// Assignment #: Arizona State University CSE205 #7
//         Name: Andrew Miller
//    StudentID: 1214962229
//      Lecture: MW 6:00pm
//  Description: The DrawPane class creates a canvas where we can use
//               mouse key to draw either a Rectangle or a Circle with different
//               colors. We can also use the the two buttons to erase the last
//				 drawn shape or clear them all.

//import any classes necessary here
//----
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class DrawPane extends BorderPane {
	private Button undoBtn, eraseBtn;
	private ComboBox<String> colorCombo;
	private RadioButton rbRect, rbCircle;
	private ArrayList<Shape> shapeList;
	private Pane canvas;
	private BorderPane drawPane;
	private VBox left;
	private HBox bottom;
	private boolean isRectangle;
	private double x1, y1, x2, y2;
	private Color color;
	private Rectangle rect;
	private Circle circ;

	// Constructor
	public DrawPane() {
		// Step #1: initialize each instance variable and set up layout
		isRectangle = true;
		color = Color.BLACK;

		drawPane = new BorderPane();

		undoBtn = new Button("Undo");
		undoBtn.setMinWidth(80.0);
		eraseBtn = new Button("Erase");
		eraseBtn.setMinWidth(80.0);

		left = new VBox();
		left.setStyle("-fx-border-style: solid; -fx-border-color: black;");
		left.setMinHeight(354);
		left.setSpacing(50);
		left.setPadding(new Insets(10));
		bottom = new HBox();
		bottom.setStyle("-fx-border-style: solid; -fx-border-color: black;");
		bottom.setPadding(new Insets(10));
		bottom.setSpacing(10);
		bottom.setAlignment(Pos.CENTER);

		// Create the color comboBox and initial its default color
		// ----
		colorCombo = new ComboBox<>();
		colorCombo.getItems().addAll("Black", "Blue", "Green", "Red", "Yellow", "Orange", "Pink");
		colorCombo.getSelectionModel().selectFirst();

		// Create the two radio buttons and also a ToggleGroup
		// so that the two radio buttons can be selected
		// mutually exclusively. Otherwise they are independent of each other
		// ----
		rbRect = new RadioButton("Rectangle");
		rbCircle = new RadioButton("Circle");
		final ToggleGroup group = new ToggleGroup();
		rbRect.setToggleGroup(group);
		rbRect.setSelected(true);
		rbCircle.setToggleGroup(group);

		// initialize shapeList, it is a data structure we used
		// to track the shape we created
		// ----
		shapeList = new ArrayList<>();

		// canvas is a Pane where we will draw rectangles and circles on it
		canvas = new Pane();
		canvas.setStyle("-fx-background-color: beige;");
		canvas.setPrefSize(493, 350);

		// initialize the remaining instance variables and set up
		// the layout
		// ----
		// ----
		left.getChildren().addAll(colorCombo, rbRect, rbCircle);
		bottom.getChildren().addAll(undoBtn, eraseBtn);
		drawPane.setLeft(left);
		drawPane.setBottom(bottom);
		drawPane.setRight(canvas);
		this.getChildren().addAll(drawPane);

		// Step #3: Register the source nodes with its handler objects
		// ----
		canvas.setOnMousePressed(new MouseHandler());
		canvas.setOnMouseDragged(new MouseHandler());
		canvas.setOnMouseReleased(new MouseHandler());
		undoBtn.setOnAction(new ButtonHandler());
		eraseBtn.setOnAction(new ButtonHandler());
		rbRect.setOnAction(new ShapeHandler());
		rbCircle.setOnAction(new ShapeHandler());
		colorCombo.setOnAction(new ColorHandler());
	}// end constructor

	// Step #2(A) - MouseHandler
	private class MouseHandler implements EventHandler<MouseEvent> {
		public void handle(MouseEvent event) {
			// handle MouseEvent here
			// Note: you can use if(event.getEventType()== MouseEvent.MOUSE_PRESSED)
			// to check whether the mouse key is pressed, dragged or released
			// write your own codes here
			// ----

			if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
				rect = new Rectangle();
				circ = new Circle();
				rect.setStroke(Color.BLACK);
				circ.setStroke(Color.BLACK);
				x1 = event.getX();
				y1 = event.getY();
				if (isRectangle) {
					rect.setX(x1);
					rect.setY(y1);
					canvas.getChildren().add(rect);
				} else {
					circ.setCenterX(x1);
					circ.setCenterY(y1);
					circ.setRadius(0);
					canvas.getChildren().add(circ);
				}
			}

			else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
				x2 = event.getX();
				y2 = event.getY();
				rect.setFill(Color.WHITE);
				circ.setFill(Color.WHITE);
				if (x2 >= canvas.getWidth()) // creates the boundaries for which the shape can be placed
					x2 = canvas.getWidth();
				if (x2 <= 0)
					x2 = 0;
				if (y2 >= canvas.getHeight())
					y2 = canvas.getHeight();
				if (y2 <= 0)
					y2 = 0;
				if (isRectangle) {
					double width = x2 - x1;
					double height = y2 - y1;
					if (width < 0) {
						rect.setTranslateX(width);
						rect.setWidth(-width);
					} else {
						rect.setWidth(width);
					}
					if (height < 0) {
						rect.setTranslateY(height);
						rect.setHeight(-height);
					} else {
						rect.setHeight(height);
					}
				} else {
					double width = x2 - x1;
					double height = y2 - y1;
					circ.setRadius(Math.sqrt((width * width) + (height * height)));
				}
			}

			else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
				rect.setFill(color);
				rect.setStroke(color);
				circ.setFill(color);
				circ.setStroke(color);
				if (isRectangle) {
					shapeList.add(rect);
				} else {
					shapeList.add(circ);
				}
			}
		}// end handle()
	}// end MouseHandler

	// Step #2(B)- A handler class used to handle events from Undo & Erase buttons
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your codes here
			// ----
			if (((Button) event.getSource()).getText() == "Undo") {
				if (shapeList.size() > 0) {
					canvas.getChildren().remove(shapeList.size() - 1);
					shapeList.remove(shapeList.size() - 1);
				}
			} else { // if the Erase button is pressed
				canvas.getChildren().clear();
				shapeList.clear();
			}
		}
	}// end ButtonHandler

	// Step #2(C)- A handler class used to handle events from the two radio buttons
	private class ShapeHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your own codes here
			// ----
			if (((RadioButton) event.getSource()).getText() == "Rectangle") {
				isRectangle = true;
			} else { // if Circle is selected
				isRectangle = false;
			}
		}
	}// end ShapeHandler

	// Step #2(D)- A handler class used to handle colors from the combo box
	private class ColorHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			// write your own codes here
			// ----
			color = Color.valueOf(colorCombo.getValue());
		}
	}// end ColorHandler

}// end class DrawPane