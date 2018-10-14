package my.examples.arc.dto;

public class ArcListDTO {

    private int number;
    private String goodsName;
    private int investmentPeriod;
    private float profitRatio;
    private long myInvestmentPrice;
    private int profits;
    private String tax;
    private String commisions;
    private long realProfits;

    public ArcListDTO() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getInvestmentPeriod() {
        return investmentPeriod;
    }

    public void setInvestmentPeriod(int investmentPeriod) {
        this.investmentPeriod = investmentPeriod;
    }

    public float getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(float profitRatio) {
        this.profitRatio = profitRatio;
    }

    public long getMyInvestmentPrice() {
        return myInvestmentPrice;
    }

    public void setMyInvestmentPrice(long myInvestmentPrice) {
        this.myInvestmentPrice = myInvestmentPrice;
    }

    public int getProfits() {
        return profits;
    }

    public void setProfits(int profits) {
        this.profits = profits;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getCommisions() {
        return commisions;
    }

    public void setCommisions(String commisions) {
        this.commisions = commisions;
    }

    public long getRealProfits() {
        return realProfits;
    }

    public void setRealProfits(long realProfits) {
        this.realProfits = realProfits;
    }
}
