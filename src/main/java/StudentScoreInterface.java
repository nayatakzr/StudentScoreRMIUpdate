import java.rmi.Remote;
import java.rmi.RemoteException;

interface StudentScoreInterface extends Remote {

    String add_promotion(String promotionId, String name) throws RemoteException;
    String add_student(String promotionId, String id, String name, int age) throws RemoteException;
    String add_exam(String promotionId, String id, String examName, int score, double coefficient) throws RemoteException;
    double calculate_average(String promotionId, String id) throws RemoteException;
    double promotion_score(String promotionId) throws RemoteException;
    String print_exam(String promotionId, String id) throws RemoteException;
}
