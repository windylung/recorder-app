package com.lees.recorderapp.dto.record.week;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Week {
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int sunday;

    public Week(int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }
    protected Week() {

    }

    public int calDifference(Week anotherWeek) {
        int diff = 0;

        if (this.monday - anotherWeek.monday > 0) diff += this.monday - anotherWeek.monday;
        if (this.tuesday - anotherWeek.tuesday > 0) diff += this.tuesday - anotherWeek.tuesday;
        if (this.wednesday - anotherWeek.wednesday > 0) diff += this.wednesday - anotherWeek.wednesday;
        if (this.thursday - anotherWeek.thursday > 0) diff += this.thursday - anotherWeek.thursday;
        if (this.friday - anotherWeek.friday > 0) diff += this.friday - anotherWeek.friday;
        if (this.saturday - anotherWeek.saturday > 0) diff += this.saturday - anotherWeek.saturday;
        if (this.sunday - anotherWeek.sunday > 0) diff += this.sunday - anotherWeek.sunday;

        return diff;
    }

    public boolean isAllZero() {
        return this.monday == 0 &&
                this.tuesday == 0 &&
                this.wednesday == 0 &&
                this.thursday == 0 &&
                this.friday == 0 &&
                this.saturday == 0 &&
                this.sunday == 0;
    }
}
