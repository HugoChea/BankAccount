package enums;

public enum OperationType {

    DEPOSIT("Deposit"),
    WITHDRAW("Withdraw");

    private String value;

    OperationType(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}
