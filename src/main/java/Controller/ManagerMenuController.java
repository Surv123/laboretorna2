package Controller;

import Model.*;
import Session.UserSession;
import Util.NewWindow;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;

public class ManagerMenuController implements Initializable {

    @FXML
    private ChoiceBox<String> employeeList;
    @FXML
    private ChoiceBox<String> apparat;
    @FXML
    private ChoiceBox<String> cabinet;

    @FXML
    private Label managerLabel;

    @FXML
    private AnchorPane scenePane;

    @FXML
    private TableView<EmployeeEntity> tableView;

    @FXML
    private RadioButton completedRadioButton, notRadioButton;

    private ObservableList orders;

    private Boolean isAlreadyUsed = false;


    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        managerLabel.setText(UserSession.getInstance().getWorker().getSurnameW());
        employeeList.getItems().addAll(getWorkerList());
        employeeList.setOnAction(this::getChosenWorker);
        apparat.getItems().addAll(getApparatList());
        apparat.setOnAction(this::getChosenApparat);
        cabinet.getItems().addAll(getCabinetList());
        cabinet.setOnAction(this::getChosenCabinet);

    }

    private List<String> getWorkerList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query q = em.createQuery("SELECT w FROM EmployeeEntity w WHERE w.usertype <> 1 and w.dateEnd is NULL");
        List<EmployeeEntity> workers = q.getResultList();
        List<String> workerNames = new ArrayList<>();
        for (EmployeeEntity w : workers) {
            workerNames.add(w.toString());
        }
        em.close();
        return workerNames;
    }

    private void getChosenWorker(ActionEvent event) {
        String worker = employeeList.getValue();
    }

    private List<String> getApparatList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query q = em.createQuery("SELECT w FROM ApparatEntity w");
        List<ApparatEntity> workers = q.getResultList();
        List<String> workerNames = new ArrayList<>();
        for (ApparatEntity w : workers) {
            workerNames.add(w.toString());
        }
        em.close();
        return workerNames;
    }


    private void getChosenCabinet(ActionEvent event) {
        String apparatString = cabinet.getValue();
    }

    private List<String> getCabinetList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query q = em.createQuery("SELECT w FROM RoomEntity w");
        List<RoomEntity> workers = q.getResultList();
        List<String> workerNames = new ArrayList<>();
        for (RoomEntity w : workers) {
            workerNames.add(w.toString());
        }
        em.close();
        return workerNames;
    }


    private void getChosenApparat(ActionEvent event) {
        String apparatString = apparat.getValue();
    }

    private String getChosenWorkerF(String fi) {
        return fi.substring(0, fi.indexOf(" "));
    }

    private String getChosenWorkerI(String fi) {
        return fi.substring(fi.indexOf(" ") + 1);
    }

    public void newOrder(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("addOrderMenu.fxml", event);
    }

    public void execution(ActionEvent event) throws IOException {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String worker = employeeList.getValue();


        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Query q = em.createQuery("SELECT l FROM EmployeeEntity l " +
                    "WHERE l.surnameW=:f and  l.nameW=:i").setParameter("f", getChosenWorkerF(worker)).setParameter("i", getChosenWorkerI(worker));
            EmployeeEntity employee = (EmployeeEntity) q.getSingleResult();
            java.util.Date date = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            employee.setDateEnd(sqlDate);
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
        employeeList.getItems().clear();
        employeeList.getItems().addAll(getWorkerList());
        employeeList.setOnAction(this::getChosenWorker);
        addExecutionLog();
    }

    public void setupTable(ActionEvent event) {
        if (completedRadioButton.isSelected()) {
            updateTable(true);
            setupTable();
            isAlreadyUsed = true;
        } else if (notRadioButton.isSelected()) {
            updateTable(false);
            setupTable();
            isAlreadyUsed = true;
        }
    }

    public void logout(ActionEvent event) {
        addManagerLogoutLog();
        NewWindow.logout(scenePane);
    }

    public void addOtvetstvenniy(ActionEvent event) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        String worker = employeeList.getValue();


        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Query q = em.createQuery("SELECT l FROM ApparatEntity l " +
                    "WHERE l.idAp=:f ").setParameter("f", Integer.parseInt(apparat.getValue()));
            ApparatEntity employee = (ApparatEntity) q.getSingleResult();
            Query q1 = em.createQuery("SELECT l FROM EmployeeEntity l " +
                    "WHERE l.surnameW=:f").setParameter("f", getChosenWorkerF(worker));
            EmployeeEntity employee1 = (EmployeeEntity) q1.getSingleResult();

            Query q2 = em.createQuery("SELECT l FROM RoomEntity l " +
                    "WHERE l.idRoom=:f").setParameter("f", Integer.parseInt(cabinet.getValue()));
            RoomEntity employee3 = (RoomEntity) q2.getSingleResult();

            employee.setEmployeeByIdEmp(employee1);
            employee.setRoomByIdRoom(employee3);
            em.persist(employee);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
                System.out.println("122142");
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        addChangeLog();
    }

    private void addManagerLogoutLog() {
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

    private void updateTable(Boolean isCompleted) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        TypedQuery<EmployeeEntity> tq;
        if (isCompleted) {
            tq = em.createQuery("SELECT o FROM EmployeeEntity o WHERE o.dateEnd IS NULL AND o.usertype<>1 ", EmployeeEntity.class);
        } else {
            tq = em.createQuery("SELECT o FROM EmployeeEntity o WHERE o.dateEnd IS NOT NULL and  o.usertype<>1 ", EmployeeEntity.class);
        }
        List<EmployeeEntity> results = tq.getResultList();
        if (orders == null) {
            orders = FXCollections.observableArrayList(results);
        } else {
            orders.clear();
            orders.addAll(results);
        }
        em.close();
    }

    private void setupTable() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();

        if (!isAlreadyUsed) {

            TableColumn<EmployeeEntity, String> fTableColumn = new TableColumn<>();
            fTableColumn.setText("Фамилия");
            fTableColumn.setMinWidth(80);
            fTableColumn.setCellValueFactory(new PropertyValueFactory<>("SurnameW"));

            TableColumn<EmployeeEntity, String> iTableColumn = new TableColumn<>();
            iTableColumn.setText("Имя");
            iTableColumn.setMinWidth(93);
            iTableColumn.setCellValueFactory(new PropertyValueFactory<>("NameW"));


            TableColumn<EmployeeEntity, String> roleTableColumn = new TableColumn<>();
            roleTableColumn.setText("Должность");
            roleTableColumn.setMinWidth(70);
            roleTableColumn.setCellValueFactory(w -> {
                if (w.getValue() != null) {
                    String result = null;
                    if (w.getValue().getUsertype() == 2) {
                        result = "Менеджер";
                    } else if (w.getValue().getUsertype() == 3) {
                        result = "Работник";
                    }
                    return new SimpleStringProperty(result);
                } else {
                    return new SimpleStringProperty("<no name>");
                }
            });

            TableColumn<EmployeeEntity, Double> salaryTableColumn = new TableColumn<>();
            salaryTableColumn.setText("Уволен");
            salaryTableColumn.setMinWidth(40);
            salaryTableColumn.setCellValueFactory(new PropertyValueFactory<>("DateEnd"));

            TableColumn<EmployeeEntity, Date> startdateTableColumn = new TableColumn<>();
            startdateTableColumn.setText("Дата");
            startdateTableColumn.setMinWidth(72);
            startdateTableColumn.setCellValueFactory(new PropertyValueFactory<>("DateStart"));

            tableView.getColumns().addAll(fTableColumn, iTableColumn, roleTableColumn, salaryTableColumn, startdateTableColumn);
            tableView.setItems(orders);
        }

    }
    public void buy(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("addApparat.fxml", event);

    }
    private void addChangeLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Назначил нового ответственного");
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
    private void addExecutionLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Удалил аппарат");
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
}
