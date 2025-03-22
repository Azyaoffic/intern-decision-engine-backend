package ee.taltech.inbankbackend.config;

/**
 * Holds all necessary constants for the decision engine.
 */
public class DecisionEngineConstants {
    public static final Integer MINIMUM_LOAN_AMOUNT = 2000;
    public static final Integer MAXIMUM_LOAN_AMOUNT = 10000;
    public static final Integer MAXIMUM_LOAN_PERIOD = 60;
    public static final Integer MINIMUM_LOAN_PERIOD = 12;
    public static final Integer SEGMENT_1_CREDIT_MODIFIER = 100;
    public static final Integer SEGMENT_2_CREDIT_MODIFIER = 300;
    public static final Integer SEGMENT_3_CREDIT_MODIFIER = 1000;

    public static final Float LIFE_EXPECTANCY_ESTONIA = 78.1f;
    public static final Float LIFE_EXPECTANCY_LATVIA = 74.5f;
    public static final Float LIFE_EXPECTANCY_LITHUANIA = 75.6f;
    public static final Float LIFE_EXPECTANCY_BALTICS_AVG = 76.0f;
    public static final Integer UNDERAGE_LIMIT = 18;
}
