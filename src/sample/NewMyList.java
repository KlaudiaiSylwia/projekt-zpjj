package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

public class NewMyList {

    public void NewList(ActionEvent actionEvent) throws Exception {

        Stage stage = new Stage();
        Parent s1parent = FXMLLoader.load(getClass().getResource("AddListName.fxml"));
        stage.setTitle("Nowa lista");
        stage.setScene(new Scene(s1parent, 300, 275));
        stage.show();


    }

    public void MyList(ActionEvent actionEvent) throws Exception {
        Stage stage4 = new Stage();
        Parent s4parent = FXMLLoader.load(getClass().getResource("ChooseList.fxml"));
        stage4.setTitle("Moje listy");
        stage4.setScene(new Scene(s4parent, 300, 275));
        stage4.show();


    }


}
