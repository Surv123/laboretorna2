package Controller;

import Model.EmployeeEntity;
import Util.NewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import javax.persistence.*;
import java.util.Date;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;

public class AddUserController {

    @FXML
    private TextField fTextField;

    @FXML
    private TextField iTextField;

    @FXML
    private TextField oTextField;

    @FXML
    private DatePicker birthdateDatePicker;

    @FXML
    private TextField salaryTextField;

    @FXML
    private RadioButton managerRadioButton, workerRadioButton;

    @FXML
    private TextField loginTextField;

    private String f;
    private String i;
    private String o;
    private int userType;
    private String login;

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    public void addNewUser(ActionEvent event) throws IOException {
        f = fTextField.getText();
        i = iTextField.getText();
        o = oTextField.getText();
        if (managerRadioButton.isSelected()) {
            userType = 2;
        } else if (workerRadioButton.isSelected()) {
            userType = 3;
        }
        login = loginTextField.getText();
        addWorker(f, i, o, userType, login);
        ENTITY_MANAGER_FACTORY.close();
        NewWindow.setNewWindow("adminMenu.fxml", event);
    }

    private void addWorker(String f, String i, String o, int userType, String login) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            EmployeeEntity worker = new EmployeeEntity();
            worker.setSurnameW(f);
            worker.setNameW(i);
            worker.setfNameW(o);
            worker.setUsertype(userType);
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            worker.setLogin(login);
            worker.setPassword(generatePassword());
            worker.setDateStart(sqlDate);
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
    public void back(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("adminMenu.fxml", event);
    }

    private String generatePassword(){
        return new Random().ints(10, 33, 122).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


}
