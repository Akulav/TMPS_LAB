package proxy;

public class bookMproxy implements Scheduler {
	private boolean isScheduled;
    private bookM bookM;

    public bookMproxy() {
        this.isScheduled = false;
        this.bookM = new bookM();
    }

    public boolean isScheduled(){
        return isScheduled;
    }
    public void setScheduled(boolean scheduled){
        isScheduled = scheduled;
    }

    private void scheduleByPhone(){
        System.out.println("Scheduled for service succesfully");
        this.isScheduled = true;
    }

    @Override
    public void book() {
        scheduleByPhone();
        if(this.isScheduled){
            this.bookM.book();
        }

    }
}
