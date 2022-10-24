import java.rmi.Naming;

class StudentScoreServer {
    public static void main	 (String[] argv) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(5555);

            Naming.rebind("rmi://localhost:5555/HelloServer"	, new StudentScoreImpl());
            System.out.println("Hello Server is ready.");
        }
        catch (Exception e) {
            System.out.println("Hello Server failed: " + e);
        }
    }
}

