package com.intertec.util;

import java.util.List;

/**
 * Created by Userpc on 14/05/2018.
 */
public class Result {

    private Boolean accepted;

    private List<String> suggestedNames;

    public Result(Boolean accepted, List<String> suggestedNames) {
        this.accepted = accepted;
        this.suggestedNames = suggestedNames;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public List<String> getSuggestedNames() {
        return suggestedNames;
    }

    public void setSuggestedNames(List<String> suggestedNames) {
        this.suggestedNames = suggestedNames;
    }
}
