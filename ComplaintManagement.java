import java.util.ArrayList;
import java.util.Scanner;

public class ComplaintManagement {

    static ArrayList<Complaint> complaints =
            new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Add Complaint
    public static void addComplaint() {

        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Complaint Category: ");
        String category = sc.nextLine();

        System.out.print("Enter Complaint Description: ");
        String description = sc.nextLine();

        Complaint complaint =
                new Complaint(id, name, category, description);

        complaints.add(complaint);

        System.out.println(
                "Complaint submitted successfully!"
        );
    }

    // Display All Complaints
    public static void displayComplaints() {

        if (complaints.isEmpty()) {

            System.out.println(
                    "No complaints available."
            );

            return;
        }

        System.out.println(
                "\nID\tStudent\tCategory\tStatus"
        );

        System.out.println(
                "----------------------------------------------"
        );

        for (Complaint c : complaints) {

            c.displayComplaint();
        }
    }

    // Search Complaint
    public static void searchComplaint() {

        System.out.print(
                "Enter Complaint ID to search: "
        );

        int id = sc.nextInt();

        boolean found = false;

        for (Complaint c : complaints) {

            if (c.getComplaintId() == id) {

                System.out.println(
                        "\nComplaint Found"
                );

                System.out.println(
                        "Complaint ID: "
                        + c.getComplaintId()
                );

                System.out.println(
                        "Student Name: "
                        + c.getStudentName()
                );

                System.out.println(
                        "Category: "
                        + c.getCategory()
                );

                System.out.println(
                        "Description: "
                        + c.getDescription()
                );

                System.out.println(
                        "Status: "
                        + c.getStatus()
                );

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Complaint not found."
            );
        }
    }

    // Update Complaint Status
    public static void updateStatus() {

        System.out.print(
                "Enter Complaint ID: "
        );

        int id = sc.nextInt();

        sc.nextLine();

        boolean found = false;

        for (Complaint c : complaints) {

            if (c.getComplaintId() == id) {

                System.out.println(
                        "1. Pending"
                );

                System.out.println(
                        "2. In Progress"
                );

                System.out.println(
                        "3. Resolved"
                );

                System.out.print(
                        "Enter new status: "
                );

                int choice = sc.nextInt();

                String status;

                switch (choice) {

                    case 1:
                        status = "Pending";
                        break;

                    case 2:
                        status = "In Progress";
                        break;

                    case 3:
                        status = "Resolved";
                        break;

                    default:
                        System.out.println(
                                "Invalid status."
                        );
                        return;
                }

                c.setStatus(status);

                System.out.println(
                        "Complaint status updated successfully!"
                );

                found = true;

                break;
            }
        }

        if (!found) {

            System.out.println(
                    "Complaint not found."
            );
        }
    }

    // Delete Complaint
    public static void deleteComplaint() {

        System.out.print(
                "Enter Complaint ID to delete: "
        );

        int id = sc.nextInt();

        boolean removed = complaints.removeIf(
                c -> c.getComplaintId() == id
        );

        if (removed) {

            System.out.println(
                    "Complaint deleted successfully!"
            );

        } else {

            System.out.println(
                    "Complaint not found."
            );
        }
    }

    // Display Pending Complaints
    public static void displayPendingComplaints() {

        boolean found = false;

        System.out.println(
                "\nPending / In Progress Complaints"
        );

        System.out.println(
                "ID\tStudent\tCategory\tStatus"
        );

        System.out.println(
                "----------------------------------------------"
        );

        for (Complaint c : complaints) {

            if (!c.getStatus().equals("Resolved")) {

                c.displayComplaint();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No pending complaints."
            );
        }
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println(
                    "\n===== COMPLAINT MANAGEMENT SYSTEM ====="
            );

            System.out.println(
                    "1. Add Complaint"
            );

            System.out.println(
                    "2. Display All Complaints"
            );

            System.out.println(
                    "3. Search Complaint"
            );

            System.out.println(
                    "4. Update Complaint Status"
            );

            System.out.println(
                    "5. Delete Complaint"
            );

            System.out.println(
                    "6. Display Pending Complaints"
            );

            System.out.println(
                    "7. Exit"
            );

            System.out.print(
                    "Enter your choice: "
            );

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addComplaint();
                    break;

                case 2:
                    displayComplaints();
                    break;

                case 3:
                    searchComplaint();
                    break;

                case 4:
                    updateStatus();
                    break;

                case 5:
                    deleteComplaint();
                    break;

                case 6:
                    displayPendingComplaints();
                    break;

                case 7:

                    System.out.println(
                            "Thank you for using Complaint Management System."
                    );

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }
    }
}