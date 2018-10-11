package my.examples.arc.dto;

public class ArcListDTO {

    private String goodsName;
    private int investmentPriod;
    private float profitRatio;
    private int investmentPrice;

    public ArcListDTO() {
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getInvestmentPriod() {
        return investmentPriod;
    }

    public void setInvestmentPriod(int investmentPriod) {
        this.investmentPriod = investmentPriod;
    }

    public float getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(float profitRatio) {
        this.profitRatio = profitRatio;
    }

    public int getInvestmentPrice() {
        return investmentPrice;
    }

    public void setInvestmentPrice(int investmentPrice) {
        this.investmentPrice = investmentPrice;
    }
}
