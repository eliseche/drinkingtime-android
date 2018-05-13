package com.eliseche.drinkingtime.api.model;

/**
 * Occasion.
 */
public class Occasion {
    private String id;
    private String name;
    private String description;
    private String languageBranch;
    private DiscreteDatetime start;
    private DiscreteDatetime end;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguageBranch() {
        return languageBranch;
    }

    public void setLanguageBranch(String languageBranch) {
        this.languageBranch = languageBranch;
    }

    public DiscreteDatetime getStart() {
        return start;
    }

    public void setStart(DiscreteDatetime start) {
        this.start = start;
    }

    public DiscreteDatetime getEnd() {
        return end;
    }

    public void setEnd(DiscreteDatetime end) {
        this.end = end;
    }

    public class DiscreteDatetime {
        private int month;
        private int day;
        private int weekDay;
        private int hour;

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getWeekDay() {
            return weekDay;
        }

        public void setWeekDay(int weekDay) {
            this.weekDay = weekDay;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }
    }
}