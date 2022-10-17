package Controller;

import Model.*;
import Session.UserSession;
import Util.NewWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import javax.persistence.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class AddApparatController implements Initializable {
    @FXML
    private AnchorPane scenePane;
    @FXML
    private ChoiceBox<String> employeeList;
    @FXML
    private ChoiceBox<String> apparat;
    @FXML
    private ChoiceBox<String> cabinet;
    @FXML
    private ChoiceBox<String> supplierList;
    @FXML
    private TableView<EquipmenttEntity> tableView;
    private ObservableList<EquipmenttEntity> logs;

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");

    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeList.getItems().addAll(getWorkerList());
        employeeList.setOnAction(this::getChosenWorker);
        apparat.getItems().addAll(getApparatList());
        apparat.setOnAction(this::getChosenApparat);
        cabinet.getItems().addAll(getCabinetList());
        cabinet.setOnAction(this::getChosenCabinet);
        supplierList.getItems().addAll(getSupplierList());
        supplierList.setOnAction(this::getChosenSupplier);
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
        Query q = em.createQuery("SELECT w FROM EquipmenttEntity w");
        List<EquipmenttEntity> workers = q.getResultList();
        List<String> workerNames = new ArrayList<>();
        for (EquipmenttEntity w : workers) {
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
        updateTable(apparatString);
        setupTable();
        System.out.println(apparat.getValue());
    }

    private void updateTable(String nameEquip) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query q = em.createQuery("SELECT l FROM EquipmenttEntity l " +
                "WHERE l.nameEquip=:f ").setParameter("f", nameEquip);
        List results = q.getResultList();
        if (logs == null) {
            logs = FXCollections.observableArrayList(results);
        } else {
            logs.clear();
            logs.addAll(results);
        }
        em.close();
    }

    private void setupTable() {


        TableColumn<EquipmenttEntity, String> activityTableColumn = new TableColumn<>();
        activityTableColumn.setText("Название");
        activityTableColumn.setMinWidth(10);
        activityTableColumn.setPrefWidth(200);
        activityTableColumn.setCellValueFactory(new PropertyValueFactory<>("NameEquip"));

        TableColumn<EquipmenttEntity, Float> activityTableColumn1 = new TableColumn<>();
        activityTableColumn1.setText("Ширина");
        activityTableColumn1.setMinWidth(10);
        activityTableColumn1.setPrefWidth(100);
        activityTableColumn1.setCellValueFactory(new PropertyValueFactory<>("widthe"));

        TableColumn<EquipmenttEntity, Float> activityTableColumn2 = new TableColumn<>();
        activityTableColumn2.setText("Высота");
        activityTableColumn2.setMinWidth(10);
        activityTableColumn2.setPrefWidth(100);
        activityTableColumn2.setCellValueFactory(new PropertyValueFactory<>("heighte"));

        TableColumn<EquipmenttEntity, Float> activityTableColumn3 = new TableColumn<>();
        activityTableColumn3.setText("Длинна");
        activityTableColumn3.setMinWidth(10);
        activityTableColumn3.setPrefWidth(100);
        activityTableColumn3.setCellValueFactory(new PropertyValueFactory<>("lengthe"));

        tableView.getColumns().addAll(activityTableColumn, activityTableColumn1, activityTableColumn2, activityTableColumn3);
        tableView.setItems(logs);
    }

    private String getChosenWorkerF(String fi) {
        return fi.substring(0, fi.indexOf(" "));
    }

    private String getChosenWorkerI(String fi) {
        return fi.substring(fi.indexOf(" ") + 1);
    }


    private List<String> getSupplierList() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        Query q = em.createQuery("SELECT w FROM SupplierEntity w");
        List<SupplierEntity> workers = q.getResultList();
        List<String> workerNames = new ArrayList<>();
        for (SupplierEntity w : workers) {
            workerNames.add(w.toString());
        }
        em.close();
        return workerNames;
    }


    private void getChosenSupplier(ActionEvent event) {
        String apparatString = supplierList.getValue();
    }

    public void buy(ActionEvent event) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            Query q2 = em.createQuery("SELECT l FROM RoomEntity l " +
                    "WHERE l.idRoom=:f").setParameter("f", Integer.parseInt(cabinet.getValue()));
            RoomEntity employee3 = (RoomEntity) q2.getSingleResult();
            ApparatEntity apparat = new ApparatEntity();
            apparat.setRoomByIdRoom(employee3);
            Date date = new Date();
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            apparat.setDateBuy(sqlDate);
            em.persist(apparat);
            et.commit();
        } catch (Exception e) {
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
        addWorkerLogoutLog();
    }
    public void back(ActionEvent event) throws IOException {
        NewWindow.setNewWindow("managerMenu.fxml", event);
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
    public void logout(ActionEvent event) {
        addManagerLogoutLog();
        NewWindow.logout(scenePane);
    }
    private void addWorkerLogoutLog() {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            LogEntity log = new LogEntity();
            log.setTime(Timestamp.valueOf(LocalDateTime.now()));
            log.setActivity("Закупил аппарат");
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
