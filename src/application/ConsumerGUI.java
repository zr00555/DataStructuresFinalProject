package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConsumerGUI extends Application{
	
		static Pane mainPane;
		static StackPane pane;
		static Scene scene;
		public static int counter = 1;
		static int counter2 = 5;
		static Stage primaryStage2;
		static Rectangle q1,q2,q3,q4,q5, background;
		static HBox qItems;
		static Text nameText1,nameText2,nameText3,nameText4,nameText5;
		static String temp1,temp2,temp3,temp4,temp5;
		
		public static void main(String[] args) {
			launch();
		}
		
		@Override
		public void start(Stage primaryStage2) throws Exception {
			
			Controller.q.enqueue("Joe");
			Controller.q.enqueue("Jan");
			Controller.q.enqueue("Jill");
			Controller.q.enqueue("Tom");
			Controller.q.enqueue("Mike");
			
			//Background
			background = new Rectangle(1000, 600);
			background.setFill(Color.WHITE);
			//QueueItems
			q1 = new Rectangle(200, 600);
			q1.setFill(Color.RED);
			
			q2 = new Rectangle(200, 600);
			q2.setFill(Color.RED);
			q2.setX(200);
			
			q3 = new Rectangle(200, 600);
			q3.setFill(Color.RED);
			q3.setX(400);
			
			q4 = new Rectangle(200, 600);
			q4.setFill(Color.RED);
			q4.setX(600);
			
			q5 = new Rectangle(200, 600);
			q5.setFill(Color.RED);
			q5.setX(800);
			
			qItems = new HBox(0);
			qItems.getChildren().addAll();
			qItems.setAlignment(Pos.BASELINE_LEFT);
			
			//Text
			
			
			if(Controller.q.front.key != null) {
			nameText1 = new Text(Controller.q.front.key);
			nameText1.setX(80);
			nameText1.setY(200);
			nameText1.setFont(Font.font(30));
			}
			if(Controller.q.front.next.key != null) {
			nameText2 = new Text(Controller.q.front.next.key);
			nameText2.setX(280);
			nameText2.setY(200);
			nameText2.setFont(Font.font(30));
			}
			if(Controller.q.front.next.next.key != null) {
			nameText3 = new Text(Controller.q.front.next.next.key);
			nameText3.setX(480);
			nameText3.setY(200);
			nameText3.setFont(Font.font(30));
			}
			if(Controller.q.front.next.next.next.key != null) {
			nameText4 = new Text(Controller.q.front.next.next.next.key);
			nameText4.setX(680);
			nameText4.setY(200);
			nameText4.setFont(Font.font(30));
			}
			if(Controller.q.front.next.next.next.next.key != null) {
			nameText5 = new Text(Controller.q.front.next.next.next.next.key);
			nameText5.setX(880);
			nameText5.setY(200);
			nameText5.setFont(Font.font(30));
			}
			
			String temp1 = nameText1.getText();
			String temp2 = nameText2.getText();
			String temp3 = nameText3.getText();
			String temp4 = nameText4.getText();
			String temp5 = nameText5.getText();
			
			HBox text = new HBox(180);
			//Enqueue button
			Button enQueueBTN = new Button("Enqueue");
			enQueueBTN.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					if(counter == 1) {
						qItems.getChildren().add(q1);
						mainPane.getChildren().add(nameText1);
						counter++;
					} else if (counter == 2) {
						qItems.getChildren().add(q2);
						nameText2.setText(temp1);
						nameText1.setText(temp2);
						mainPane.getChildren().add(nameText2);
						counter++;
					} else if (counter == 3) {
						qItems.getChildren().add(q3);
						nameText3.setText(temp1);
						nameText2.setText(temp2);
						nameText1.setText(temp3);
						mainPane.getChildren().add(nameText3);
						counter++;
					} else if (counter == 4) {
						qItems.getChildren().add(q4);
						nameText4.setText(temp1);
						nameText3.setText(temp2);
						nameText2.setText(temp3);
						nameText1.setText(temp4);
						mainPane.getChildren().add(nameText4);
						counter++;
					} else if (counter == 5) {
						qItems.getChildren().add(q5);
						nameText5.setText(temp1);
						nameText4.setText(temp2);
						nameText3.setText(temp3);
						nameText2.setText(temp4);
						nameText1.setText(temp5);
						mainPane.getChildren().add(nameText5);
						counter++;
					}
				}
			});
			
			//Completion button
			Button completedBTN = new Button("Order Complete");
			completedBTN.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
					
					if(counter == 6) {
						q5.setFill(Color.GREEN);
						counter--;
						Controller.q.dequeue();
					} else if (counter == 5) {
						q4.setFill(Color.GREEN);
						counter--;
					}else if (counter == 4) {
						q3.setFill(Color.GREEN);
						counter--;
					}else if (counter == 3) {
						q2.setFill(Color.GREEN);
						counter--;
					}else if (counter == 2) {
						q1.setFill(Color.GREEN);
						counter--;
					}
				}
				});
			
			Button deQueueBTN = new Button("Dequeue");
			deQueueBTN.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent e) {
				
					if (q5.getFill() == Color.GREEN) {
						qItems.getChildren().remove(q5);
						mainPane.getChildren().remove(nameText5);
						q5.setFill(Color.RED);
					}else if (q4.getFill() == Color.GREEN) {
						qItems.getChildren().remove(q4);
						mainPane.getChildren().remove(nameText4);
						q4.setFill(Color.RED);
					} else if (q3.getFill() == Color.GREEN) {
						qItems.getChildren().remove(q3);
						mainPane.getChildren().remove(nameText3);
						q3.setFill(Color.RED);
					} else if (q2.getFill() == Color.GREEN) {
						qItems.getChildren().remove(q2);
						mainPane.getChildren().remove(nameText2);
						q2.setFill(Color.RED);
					} else if(q1.getFill() == Color.GREEN) {
						qItems.getChildren().remove(q1);
						mainPane.getChildren().remove(nameText1);
						q1.setFill(Color.RED);
					} 
					
					
					
					
				}
				});
			
			HBox buttons = new HBox(20);
			buttons.getChildren().addAll(enQueueBTN, completedBTN, deQueueBTN);
			buttons.setAlignment(Pos.BOTTOM_CENTER);
			
			mainPane = new Pane(background, qItems, buttons);
			scene = new Scene(mainPane);
			primaryStage2.setScene(scene);
			primaryStage2.show();
		}
		
		/*ConsumerGUI() {
			mainPane = new Pane(background, qItems, addOrder);
			scene = new Scene(mainPane);
			primaryStage2.setScene(scene);
			primaryStage2.show();
		}*/

}