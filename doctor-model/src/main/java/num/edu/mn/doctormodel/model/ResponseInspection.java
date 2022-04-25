package num.edu.mn.doctormodel.model;


public class ResponseInspection
{
    private Long inspectionid;
    private Long userid;
    private Object vitalsigns;
    private String inspectiontype;
    private String diagnosis;
    private String reason;
    private String isdisease;
    private int isAm13;
    private String treatment;
    private String isparalyzed;

    public ResponseInspection() {
    }

    public ResponseInspection(Long inspectionid, Long userid, Object vitalsigns, String inspectiontype, String diagnosis, String reason, String isdisease, int isAm13, String treatment, String isparalyzed) {
        this.inspectionid = inspectionid;
        this.userid = userid;
        this.vitalsigns = vitalsigns;
        this.inspectiontype = inspectiontype;
        this.diagnosis = diagnosis;
        this.reason = reason;
        this.isdisease = isdisease;
        this.isAm13 = isAm13;
        this.treatment = treatment;
        this.isparalyzed = isparalyzed;
    }

    public Long getInspectionid() {
        return inspectionid;
    }

    public void setInspectionid(Long inspectionid) {
        this.inspectionid = inspectionid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Object getVitalsigns() {
        return vitalsigns;
    }

    public void setVitalsigns(Object vitalsigns) {
        this.vitalsigns = vitalsigns;
    }

    public String getInspectiontype() {
        return inspectiontype;
    }

    public void setInspectiontype(String inspectiontype) {
        this.inspectiontype = inspectiontype;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getIsdisease() {
        return isdisease;
    }

    public void setIsdisease(String isdisease) {
        this.isdisease = isdisease;
    }

    public int getIsAm13() {
        return isAm13;
    }

    public void setIsAm13(int isAm13) {
        this.isAm13 = isAm13;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getIsparalyzed() {
        return isparalyzed;
    }

    public void setIsparalyzed(String isparalyzed) {
        this.isparalyzed = isparalyzed;
    }
}
