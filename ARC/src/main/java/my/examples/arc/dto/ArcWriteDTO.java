package my.examples.arc.dto;

public class ArcWriteDTO {
    String id;
    int goodsCode;
    int investmentPeriod;
    double investmentPrice;

    public ArcWriteDTO(String id, int goodsCode, int investPeriod, double investPrice) {
        this.id = id;
        this.goodsCode = goodsCode;
        this.investmentPeriod = investPeriod;
        this.investmentPrice = investPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(int goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getInvestmentPeriod() {
        return investmentPeriod;
    }

    public void setInvestmentPeriod(int investmentPeriod) {
        this.investmentPeriod = investmentPeriod;
    }

    public double getInvestmentPrice() {
        return investmentPrice;
    }

    public void setInvestmentPrice(double investmentPrice) {
        this.investmentPrice = investmentPrice;
    }
}