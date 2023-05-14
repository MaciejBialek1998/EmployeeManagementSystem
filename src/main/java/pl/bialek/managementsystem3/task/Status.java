package pl.bialek.managementsystem3.task;

public enum Status {
    NOT_STARTED("Not started")
    ,IN_PROGRESS("In progress");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
