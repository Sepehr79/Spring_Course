package spring_course.aop.before.beans;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Phone {

    private String imeiInformation;
    private String ipAddress;
    private String bluetoothAddress;
    private String serialNumber;
    private Date lastUpdate;
    private String company;

    public Phone(String imeiInformation, String ipAddress, String bluetoothAddress, String serialNumber, Date lastUpdate, String company) {
        this.imeiInformation = imeiInformation;
        this.ipAddress = ipAddress;
        this.bluetoothAddress = bluetoothAddress;
        this.serialNumber = serialNumber;
        this.lastUpdate = lastUpdate;
        this.company = company;
    }

    public Phone() {
    }

    public String getImeiInformation() {
        return imeiInformation;
    }

    public void setImeiInformation(String imeiInformation) {
        this.imeiInformation = imeiInformation;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getBluetoothAddress() {
        return bluetoothAddress;
    }

    public void setBluetoothAddress(String bluetoothAddress) {
        this.bluetoothAddress = bluetoothAddress;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void call(){
        System.out.println("Call method invoked!");
    }
}
