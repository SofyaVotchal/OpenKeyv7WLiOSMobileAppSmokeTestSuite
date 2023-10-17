package whitelabelauberge.setups;

import java.util.List;

public class YAMLGetterSetter {

    private String environment;
    private List<YAMLGetterSetter> desired_capabilities;
    private String name;
    private String type;
    private String os_version;
    private String device;
    private String bundleId;
    private String xcodeOrgId;
    private String xcodeSigningId;
    private String udid;
    private String automationName;
    private String orientation;
    private int doorLockTotalCount;

    public String getEnvironment() {

        return environment;
    }

    public void setEnvironment(String environment) {

        this.environment = environment;
    }

    public List<YAMLGetterSetter> getDesired_capabilities() {

        return desired_capabilities;
    }

    public void setDesired_capabilities(List<YAMLGetterSetter> desired_capabilities) {

        this.desired_capabilities = desired_capabilities;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String getOS_version() {

        return os_version;
    }

    public void setOS_version(String os_version) {

        this.os_version = os_version;
    }

    public String getDevice() {

        return device;
    }

    public void setDevice(String device) {

        this.device = device;
    }

    public String getBundleId() {

        return bundleId;
    }

    public void setBundleId(String bundleId) {

        this.bundleId = bundleId;
    }

    public String getXcodeOrgId() {

        return xcodeOrgId;
    }

    public void setXcodeOrgId(String xcodeOrgId) {

        this.xcodeOrgId = xcodeOrgId;
    }

    public String getXcodeSigningId() {

        return xcodeSigningId;
    }

    public void setXcodeSigningId(String xcodeSigningId) {

        this.xcodeSigningId = xcodeSigningId;
    }

    public String getUDID() {

        return udid;
    }

    public void setUDID(String udid) {

        this.udid = udid;
    }

    public String getAutomationName() {

        return automationName;
    }

    public void setAutomationName(String automationName) {

        this.automationName = automationName;
    }

    public String getOrientation() {

        return orientation;
    }

    public void setOrientation(String orientation) {

        this.orientation = orientation;
    }

    // Getters and setters
    @Override
    public String toString() {

        return "\nname : " +name + "\ntype: " + type + "\nos_version: " + os_version + "device: " + device + "\ndesired_capabilities: " + desired_capabilities + "\n";
    }

    public int getDoorLockTotalCount() {
        return doorLockTotalCount;
    }

    public void setDoorLockTotalCount(int doorLockTotalCount) {
        this.doorLockTotalCount = doorLockTotalCount;
    }
}


