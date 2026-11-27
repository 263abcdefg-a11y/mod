package com.wmem100002.teamod.agriculture;

/**
 * Realistic Rice Varieties (Strictly named 農林〇〇号, zero ministry/agency names)
 */
public enum RiceVariety {
    NORIN_1("norin_1", "農林1号", 1.35f, 0.90f, 0.65f, 1.00f, 1.15f),
    NORIN_8("norin_8", "農林8号", 0.85f, 0.70f, 0.70f, 1.45f, 1.25f),
    NORIN_22("norin_22", "農林22号", 1.00f, 0.95f, 0.95f, 1.10f, 1.20f),
    NORIN_100("norin_100", "農林100号", 0.90f, 0.55f, 0.50f, 1.05f, 1.60f);

    private final String id;
    private final String displayName;
    private final float growthSpeedMultiplier; // 早生・晩生特性
    private final float coldResistance;        // 耐冷性 (0.0 - 1.0)
    private final float blastResistance;       // いもち病抵抗性 (0.0 - 1.0)
    private final float yieldMultiplier;       // 収量性
    private final float flavorQuality;         // 食味・栄養バフ倍率

    RiceVariety(String id, String displayName, float growthSpeedMultiplier,
                float coldResistance, float blastResistance, float yieldMultiplier, float flavorQuality) {
        this.id = id;
        this.displayName = displayName;
        this.growthSpeedMultiplier = growthSpeedMultiplier;
        this.coldResistance = coldResistance;
        this.blastResistance = blastResistance;
        this.yieldMultiplier = yieldMultiplier;
        this.flavorQuality = flavorQuality;
    }

    public String getId() { return id; }
    public String getDisplayName() { return displayName; }
    public float getGrowthSpeedMultiplier() { return growthSpeedMultiplier; }
    public float getColdResistance() { return coldResistance; }
    public float getBlastResistance() { return blastResistance; }
    public float getYieldMultiplier() { return yieldMultiplier; }
    public float getFlavorQuality() { return flavorQuality; }
}
