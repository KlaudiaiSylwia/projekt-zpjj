package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.io.IOException;
import java.util.List;




public class AddProd {

    public static SessionFactory sessionFactory;
    public TextField listname;
    public TextField productname;
    public TextField quantity;

    public TableView<Products> prodList;
    public TableColumn<Products, Integer> idColumn;
    public TableColumn <Products, String>prodColumn;
    public TableColumn <Products, String>quantColumn;
    public ObservableList<Products> products;

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
            StandardServiceRegistryBuilder.destroy(registry);

        }


    }



    public void AddProduct(ActionEvent actionEvent) throws Exception{
      //  products.add(new Products (productname.getText(), quantity.getText()));

     String pname = this.productname.getText();
     String quant = this.quantity.getText();

     Products products = new Products(pname, quant);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(products);

        session.getTransaction().commit();
       /* session.close();*/

    }

    public void DelProduct(ActionEvent actionEvent)throws Exception {
       /* Session session = sessionFactory.openSession();
        session.beginTransaction();

        Products products = (Products) session.get(Products.class, Long.valueOf(id.getText()));
        session.delete(products);

        session.getTransaction().commit();
        session.close();;
*/
       /* ObservableList selectedItems = prodList.getSelectionModel().getSelectedItems();
        Products products = prodList.getSelectionModel().getSelectedItem();
        prodList.getItems().remove(selectedItems);
        */

    }

    public void SaveList(ActionEvent actionEvent) throws IOException {
        Stage stage3 = new Stage();
        stage3.initModality(Modality.APPLICATION_MODAL);
        Parent s3parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        stage3.setTitle("Lista Zakupów");
        stage3.setScene(new Scene(s3parent, 300, 275));
        stage3.show();
        String lname = listname.getText();

        Lists lists = new Lists(lname);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(lists);

        session.getTransaction().commit();

    }

    public void prodList(SortEvent<TableView> tableViewSortEvent) {

    }
}
