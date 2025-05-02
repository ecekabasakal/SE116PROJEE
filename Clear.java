public class Clear {
    
    private FSM fsm;

    public Clear(FSM fsm) {
        this.fsm = fsm;
    }
    public void handleClear() {
        fsm.clear();
        System.out.println("FSM cleared.");
    }
}


