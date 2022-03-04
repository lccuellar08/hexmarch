package hexmarch;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Dryocampa Rubicunda
public class DryRubi implements Serializable {
    private String name;
    private LocalDate birthDate;
    private int totalSaturation;
    private int totalEnergy;
    private Stage currentStage;

    private final int MAX_SATURATION = 20;
    private final int MAX_ENERGY = 20;

    // Creating a brand new
    public DryRubi(String name) {
        this.name = name;
        this.birthDate = LocalDate.now();
        this.totalSaturation = 10;
        this.totalEnergy = 10;
        this.currentStage = Stage.EGG;
    }

    public DryRubi(String name, LocalDate birthday, int totalSaturation, int totalEnergy, Stage currentStage) {
        this.name = name;
        this.birthDate = birthday;
        this.totalSaturation = totalSaturation;
        this.totalEnergy = totalEnergy;
        this.currentStage = currentStage;
    }

    public int getTotalEnergy() {
        return totalEnergy;
    }

    public int getTotalSaturation() {
        return totalSaturation;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }

    public int eatFood() {
        switch(currentStage) {
            case EGG:
            case PUPA:
                // Eggs and Pupa's don't eat
                break;
            case MOTH:
            case CATERPILLAR:
                if(this.totalSaturation < this.MAX_SATURATION) {
                    this.totalSaturation += 3;
                } // Else do nothing, too full to eat
                break;
        }

        return this.totalSaturation;
    }

    public int play() {
        switch(currentStage) {
            case EGG:
            case PUPA:
                // Eggs and Pupa's don't play
                break;
            case MOTH:
                if(this.totalEnergy > 0) {
                    this.totalEnergy -= 5;
                }
                break;
            case CATERPILLAR:
                if(this.totalEnergy > 0) {
                    this.totalEnergy -= 3;
                } // Else do nothing, too tired to play
                break;
        }
        return this.totalEnergy;
    }

    public void tick() {
        if(this.currentStage != Stage.EGG) {
            if (this.totalEnergy < this.MAX_ENERGY)
                this.totalEnergy += 1;
            if (this.totalSaturation > 0)
                this.totalSaturation -= 1;
        }

        long noOfDaysSinceBirth = ChronoUnit.DAYS.between(this.birthDate, LocalDate.now());
        if(noOfDaysSinceBirth >= 7) {
            this.currentStage = Stage.MOTH;
        } else if(noOfDaysSinceBirth >= 5) {
            this.currentStage = Stage.PUPA;
        } else if(noOfDaysSinceBirth >= 1) {
            this.currentStage = Stage.CATERPILLAR;
        } else {
            this.currentStage = Stage.EGG;
        }
    }

    @Override
    public String toString() {
        return "name:\t\t\t"+this.name+"\nbirthDate:\t\t"+this.birthDate+"\ntotalSaturation:\t"+this.totalSaturation
                +"\ntotalEnergy:\t\t"+this.totalEnergy+"\ncurrentStage:\t\t"+this.currentStage;
    }

    public enum Stage {
        EGG,
        CATERPILLAR,
        PUPA,
        MOTH
    }
}
