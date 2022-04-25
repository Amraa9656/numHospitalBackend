package num.edu.mn.usermodel.Usermodel.Model;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class ResGenaral
{
    private Integer code;
    private String status;
    private String message;
    private Object data;
    private String tsetsgee;

    public ResGenaral() {
    }

    public ResGenaral(Integer code, String status, String message, Object data, String tsetsgee) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.tsetsgee = tsetsgee;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public String getTsetsgee() {
        return tsetsgee;
    }

    public void setTsetsgee(String tsetsgee) {
        this.tsetsgee = tsetsgee;
    }
}
