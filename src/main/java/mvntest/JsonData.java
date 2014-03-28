package mvntest;

import java.util.List;

/**
 * Created by john on 14-3-3.
 */
public class JsonData {

    private String errMsg;
    private List<MeetingRoom> data;
    private Object page;

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public List<MeetingRoom> getData() {
        return data;
    }

    public void setData(List<MeetingRoom> data) {
        this.data = data;
    }

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }
}
