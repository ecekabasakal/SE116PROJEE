public void clear() {
    try {
        // Semboller
        if (symbols != null) {
            symbols.clear();
        }

        // StatesManager varsa onu temizle
        if (StatesManager != null && statesManager.getStates() != null) {
            statesManager.getStates().clear();
        }

        // TransitionManager varsa onu da temizle
        if (TransitionManager != null) {
            transitionManager.clear();
        }

        System.out.println("FSM cleared.");
    } catch (Exception e) {
        System.out.println("Error during FSM clearing: " + e.getMessage());
    }
}