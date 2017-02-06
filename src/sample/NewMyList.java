package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;


public class NewMyList {
    public static SessionFactory sessionFactory;
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

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Lists> lists =  session.createCriteria(Lists.class).list();
        lists.forEach(list -> System.out.println(list.getNamelist()+" "+list.getId()));
        session.close();


    }


}
