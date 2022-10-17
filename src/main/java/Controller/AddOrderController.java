
package Controller;

import Model.OrderrEntity;
import Model.WorkerEntity;
import Session.OrderSession;
import Util.NewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;


public class AddOrderController {
    @FXML
    private TextField fTextField;

    @FXML
    private TextField iTextField;

    @FXML
    private TextField oTextField;

    @FXML
    private TextField telTextField;

    @FXML
    private TextField addressTextField;

    private String f;
    private String i;
    private String o;
    private String tel;
    private String address;


    private void addApplicatoin(String f, String i, String o, LocalDate birthdate, double salary, int userType, String login) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            WorkerEntity worker = new WorkerEntity();
            worker.setF(f);
            worker.setI(i);
            worker.setO(o);
            worker.setBirthdate(java.sql.Date.valueOf(birthdate));
            worker.setSalary(salary);
            worker.setUsertype(userType);
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            worker.setLogin(login);
            worker.setPassword(generatePassword());
            worker.setStartdate(sqlDate);
            em.persist(worker);
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

    public void cancel(ActionEvent event) throws IOException {
        //OrderSession.getInstance().cleanOrderSession();
        NewWindow.setNewWindow("managerMenu.fxml", event);
    }

    private void saveOrder(String f, String i, String o, String tel, String address) {
        OrderrEntity order = new OrderrEntity();
        order.setF(f);
        order.setI(i);
        order.setO(o);
        order.setTel(tel);
        order.setAddress(address);
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        order.setOrderdate(sqlDate);
        OrderSession.getInstance(order);
    }


}

