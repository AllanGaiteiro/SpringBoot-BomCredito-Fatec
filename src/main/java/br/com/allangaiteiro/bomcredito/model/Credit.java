package br.com.allangaiteiro.bomcredito.model;

public class Credit {
    private float valueMin;
    private float valueMax;
    private String guarantee;

    public Credit() {
    }

    public Credit(float valueMin, float valueMax, String guarantee) {
        this.valueMin = valueMin;
        this.valueMax = valueMax;
        this.guarantee = guarantee;
    }

    public float getValueMin() {
        return valueMin;
    }

    public void setValueMin(float valueMin) {
        this.valueMin = valueMin;
    }

    public float getValueMax() {
        return valueMax;
    }

    public void setValueMax(float valueMax) {
        this.valueMax = valueMax;
    }

    public String getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(String guarantee) {
        this.guarantee = guarantee;
    }

    @Override
    public String toString() {
        return "Credit [guarantee=" + guarantee + ", valueMax=" + valueMax + ", valueMin=" + valueMin + "]";
    }

}
