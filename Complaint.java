public class Complaint {

    private int complaintId;
    private String studentName;
    private String category;
    private String description;
    private String status;

    // Constructor
    public Complaint(int complaintId, String studentName,
                     String category, String description) {

        this.complaintId = complaintId;
        this.studentName = studentName;
        this.category = category;
        this.description = description;
        this.status = "Pending";
    }

    // Getters

    public int getComplaintId() {
        return complaintId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }

    // Display complaint
    public void displayComplaint() {

        System.out.println(
            complaintId + "\t" +
            studentName + "\t" +
            category + "\t" +
            status
        );
    }
}