package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class AddList {

    public Button closelist;
    public TextField listname;
    public static SessionFactory sessionFactory;
    public ObservableList<Products> list;

    @FXML
    public void initialize() {
        setUpHibernate();
    }

    private void setUpHibernate() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);

        }
    }



    public void AddList(ActionEvent actionEvent) throws Exception {
        if (listname.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd!");
            alert.setHeaderText("Nie uzupełniłeś nazwy listy.");
            alert.setContentText("Podaj nazwę nowej listy.");

            alert.showAndWait();



        } else {
            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            Parent s2parent = FXMLLoader.load(getClass().getResource("AddProd.fxml"));
            stage2.setTitle("Tworzenie listy zakupów");
            Scene scene = new Scene(s2parent, 300, 275);
            Label label = (Label) scene.lookup("#listtitle");
            label.setText(listname.getText());
            stage2.setScene(scene);
            stage2.show();

           String lname = listname.getText();

            Lists lists = new Lists(lname);

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            session.save(lists);

            session.getTransaction().commit();


        }




        }

  /**  public List<Lists> listsList() {
        List<Lists> list = new ArrayList<>();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        list = session.createQuery("from Lists").list();
        session.getTransaction().commit();
        session.close();
        return list();
    }

    private List<Lists> list() {
        return list();
    }


*/

    public void CloseList(ActionEvent actionEvent) {
        Stage stage = (Stage) closelist.getScene().getWindow();
        stage.close();


    }
}
