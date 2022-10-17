package Session;

import Model.EmployeeEntity;

public final class UserSession {
    private static UserSession instance;

    private EmployeeEntity worker;

    public UserSession(EmployeeEntity worker) {
        this.worker = worker;
    }

    public static UserSession getInstance(EmployeeEntity worker) {
        if (instance == null) {
            instance = new UserSession(worker);
        }
        return instance;
    }

    public static UserSession getInstance() {
        return instance;
    }

    public EmployeeEntity getWorker() {
        return worker;
    }

    public void cleanUserSession() {
        worker = null;
    }


}
