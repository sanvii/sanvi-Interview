package com.ubs.opsit.interviews;

package com.technologyconversations.learning.kata.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TimeConverterImpl implement TimeConverter {

    public String[] convertTime(String time) {
        List<Integer> parts = new ArrayList<Integer>();
        for (String part : time.split(":")) {
            parts.add(Integer.parseInt(part));
        }
        return new String[] {
                getSeconds(parts.get(2)),
                getTopHours(parts.get(0)),
                getBottomHours(parts.get(0)),
                getTopMinutes(parts.get(1)),
                getBottomMinutes(parts.get(1))
        };
    }

    protected String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }

    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }

    protected String getBottomHours(int number) {
        return getOnOff(4, number % 5);
    }

    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }

    protected String getBottomMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    // Default value for onSign would be useful
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";
        // String multiplication would be useful
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }

    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }

}
