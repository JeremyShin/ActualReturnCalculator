package my.examples.arc.dto;

public class ArcWriteDto {
    String id;
    int gdsCd;
    int investPeriod;
    double investPrice;

    public ArcWriteDto(String id, int gdsCd, int investPeriod, double investPrice) {
        this.id = id;
        this.gdsCd = gdsCd;
        this.investPeriod = investPeriod;
        this.investPrice = investPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGdsCd() {
        return gdsCd;
    }

    public void setGdsCd(int gdsCd) {
        this.gdsCd = gdsCd;
    }

    public int getInvestPeriod() {
        return investPeriod;
    }

    public void setInvestPeriod(int investPeriod) {
        this.investPeriod = investPeriod;
    }

    public double getInvestPrice() {
        return investPrice;
    }

    public void setInvestPrice(double investPrice) {
        this.investPrice = investPrice;
    }
}