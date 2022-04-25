package num.edu.mn.doctormodel.model;

public class ResVitalsigns
{
    private Integer code;
    private String status;
    private String message;
    private Long vitalsignid;

    public ResVitalsigns() {
    }

    public ResVitalsigns(Integer code, String status, String message, Long vitalsignid) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.vitalsignid = vitalsignid;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getVitalsignid() {
        return vitalsignid;
    }

    public void setVitalsignid(Long vitalsignid) {
        this.vitalsignid = vitalsignid;
    }
}
