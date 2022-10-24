public class Promotion {
    private StudentRecord studentRecord;
    private String promotionId;
    private String name;
    private String description;

    public Promotion(StudentRecord studentRecord, String promotionId, String name) {
        this.studentRecord = studentRecord;
        this.promotionId = promotionId;
        this.name = name;
    }

    public StudentRecord getStudentRecord() {
        return studentRecord;
    }

    public void setStudentRecord(StudentRecord studentRecord) {
        this.studentRecord = studentRecord;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
