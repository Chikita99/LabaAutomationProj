package myproject.services.exceptions;

public class MissingBuildingException extends Exception {

    private String buildingType;
    private int requiredCount;

    public MissingBuildingException(String buildingType, int requiredCount) {
        super(buildingType + " is missing. Required at least " + requiredCount + " object(s).");
        this.buildingType = buildingType;
        this.requiredCount = requiredCount;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getRequiredCount() {
        return requiredCount;
    }

}

