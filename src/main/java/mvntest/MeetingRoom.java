package mvntest;

import java.io.Serializable;

/**
 * Created by john on 14-3-3.
 */
public class MeetingRoom implements Serializable {

    private Integer areaId;
    private Integer roomId;
    private String areaName;
    private String roomName;
    private Integer roomSize;



    public MeetingRoom() {
    }

    public MeetingRoom(Integer areaId, Integer roomId) {
        this.areaId = areaId;
        this.roomId = roomId;
    }

    public MeetingRoom(Integer areaId, Integer roomId, String areaName, String roomName) {
        this.areaId = areaId;
        this.roomId = roomId;
        this.areaName = areaName;
        this.roomName = roomName;
    }

    public Integer getAreaId() {
        return areaId != null ? areaId.intValue() : 0;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public Integer getRoomId() {
        return roomId != null ? roomId.intValue() : 0;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getRoomSize() {
        return roomSize != null ? roomSize : 0;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

}
