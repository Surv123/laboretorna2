package Controller;

import Model.*;
import Session.UserSession;

import Util.NewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javax.persistence.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

public class WorkerMenuController implements Initializable {

    @FXML
    private Label workerLabel;

    @FXML
    private ListView<ApparatEntity> servicesListView;

    @FXML
    private Label infoLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label typeLabel;
    @FXML
    private TextField priceTF, company;

    @FXML
    private Label materialLabel;

    @FXML
    private Label damageLabel;

    @FXML
    private Circle coloredCircle;

    @FXML
    private AnchorPane scenePane;

    private ApparatEntity apparat;


    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        workerLabel.setText(UserSession.getInstance().getWorker().getSurnameW());
        servicesListView.getItems().addAll(getThingServiceList());


    }



    public void logout(ActionEvent event){
        addWorkerLogoutLog();
        NewWindow.logout(scenePane);
    }

    public void price(ActionEvent event){
        ApparatEntity apparat = servicesListView.getSelectionModel().getSelectedItem();
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Query q = em.createQuery("SELECT l FROM ApparatEntity l " +
                    "WHERE l.idAp=:f ").setParameter("f", Integer.parseInt(apparat.toString()));
            ApparatEntity employee = (ApparatEntity) q.getSingleResult();
            employee.setPriceAp(Integer.parseInt(priceTF.getText()));
            em.persist(employee);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void fix(ActionEvent actionEvent){
        ApparatEntity apparat = servicesListView.getSelectionModel().getSelectedItem();
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            RepairsEntity repairs = new RepairsEntity();
            Query q1 = em.createQuery("select a from ApparatEntity a where a.idAp=:f").setParameter("f", Integer.parseInt(apparat.toString()));
            ApparatEntity apparat1 = (ApparatEntity) q1.getSingleResult();
            repairs.setPrice(Integer.parseInt(priceTF.getText()));
            repairs.setApparatByIdAp(apparat1);
            repairs.setExecutor(company.getText());
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            repairs.setDateRepair(sqlDate);
            em.persist(repairs);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    private void addWorkerLogoutLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Вышел из системы");
            log.setEmployeeByIdWorker(UserSession.getInstance().getWorker());
            em.persist(log);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }





    private ArrayList<ApparatEntity> getThingServiceList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<ApparatEntity> tq = em.createQuery("SELECT ts FROM ApparatEntity ts INNER JOIN EmployeeEntity wts ON ts.employeeByIdEmp.idWorker = wts.idWorker WHERE ts.employeeByIdEmp.idWorker=:idWorker", ApparatEntity.class);
        tq.setParameter("idWorker", UserSession.getInstance().getWorker().getIdWorker());
        ArrayList<ApparatEntity> result = new ArrayList<>(tq.getResultList());
        em.close();
        return result;
    }





}
