package ir.khorrami.mynewapp.model;

public class StackOverFlow {
    private int quota_max,error_message;

    public StackOverFlow() {
    }


    public StackOverFlow(int quota_max, int error_message) {
        this.quota_max = quota_max;
        this.error_message = error_message;
    }

    public int getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(int quota_max) {
        this.quota_max = quota_max;
    }

    public int getError_message() {
        return error_message;
    }

    public void setError_message(int error_message) {
        this.error_message = error_message;
    }
}
