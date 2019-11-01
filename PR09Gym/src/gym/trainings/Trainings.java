package gym.trainings;

public abstract class Trainings {

    private static Integer totalTrainingsInGym = 0;
    private TrainingType type;
    private DifficultyLevel xpLevel;
    private Integer maxPeople;




    public enum TrainingType {
        CROSSTRAINING, SPINNING, WRESTLING, SWIMMING
    }

    public enum DifficultyLevel {
        LOW, MEDIUM, HARD
    }

    public Trainings(TrainingType type, DifficultyLevel xpLevel, Integer maxPeople) {
        this.type = type;
        this.xpLevel = xpLevel;
        this.maxPeople = maxPeople;
        totalTrainingsInGym += 1;
    }


    public static Trainings makeSpinningClass(TrainingType type, DifficultyLevel xpLevel, Integer maxPeople) {
        return new MakeSpinningClass(type, xpLevel, maxPeople);
    }

    public static Trainings makeCrossTrainingClass(TrainingType type, DifficultyLevel xpLevel, Integer maxPeople) {
        return new MakeCrossTrainingClass(type, xpLevel, maxPeople);
    }

    public static Trainings makeSwimmingClass(TrainingType type, DifficultyLevel xpLevel, Integer maxPeople) {
        return new MakeSwimmingClass(type, xpLevel, maxPeople);
    }

    public TrainingType getType() {
        return type;
    }

    public DifficultyLevel getXpLevel() {
        return xpLevel;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public static Integer getTotalTrainingsInGym() {
        return totalTrainingsInGym;
    }

    @Override
    public String toString() {
        return "Training type is " + type + ". Experience level: " + xpLevel + ". Max people in training: " + maxPeople;
    }
}
