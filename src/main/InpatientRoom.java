package main;

public class InpatientRoom {
    private String[] inpatienteRoomStatus;
    private String[] inpatienteRoomsName;
    private String[] inpatienteRoomsTel;

    public InpatientRoom(String[] inpatienteRoomStatus, String[] inpatienteRoomsName, String[] inpatienteRoomsTel) {
        this.inpatienteRoomStatus = inpatienteRoomStatus;
        this.inpatienteRoomsName = inpatienteRoomsName;
        this.inpatienteRoomsTel = inpatienteRoomsTel;
    }

    public String[] getInpatienteRoomStatus() {
        return inpatienteRoomStatus;
    }

    public void setInpatienteRoomStatus(String[] inpatienteRoomStatus) {
        this.inpatienteRoomStatus = inpatienteRoomStatus;
    }

    public String[] getInpatienteRoomsName() {
        return inpatienteRoomsName;
    }

    public void setInpatienteRoomsName(String[] inpatienteRoomsName) {
        this.inpatienteRoomsName = inpatienteRoomsName;
    }

    public String[] getInpatienteRoomsTel() {
        return inpatienteRoomsTel;
    }

    public void setInpatienteRoomsTel(String[] inpatienteRoomsTel) {
        this.inpatienteRoomsTel = inpatienteRoomsTel;
    }
}
