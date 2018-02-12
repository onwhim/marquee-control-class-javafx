package marqueectrl;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import library.Marquee;

public class FXMLMainController implements Initializable {
    @FXML 
    private Button btnExitApp;
    @FXML
    private Label lblStatus;
    @FXML
    private AnchorPane pnlMain;    
    @FXML
    private Pane pnlMarquee;
        
    @FXML 
    private void btnExitApp_Click() {
        lblStatus.setText("Closing App...");

        Thread thread = new Thread() {
           public void run() {
               try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) { }
               Platform.exit();
                System.exit(0);
           }
       };
       thread.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Marquee marquee = new Marquee("This is the initialization content that has been chosen to appear...");
        marquee.setColor("white"); 
        marquee.setStyle("-fx-font: bold 20 arial;"); 
        marquee.setBoundsFrom(pnlMain); 
        marquee.moveDownBy(7);
        marquee.setScrollDuration(18); 
        
        pnlMarquee.getChildren().add(marquee); 
        marquee.run();
    }    
}
