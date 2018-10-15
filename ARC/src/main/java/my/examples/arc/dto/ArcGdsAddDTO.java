package my.examples.arc.dto;

public class ArcGdsAddDTO {
    private int goodsCode;
    private float profitRatio;
    private float commisions;

    public ArcGdsAddDTO(int goodsCode, Float profitRatio, float commisions) {
        this.goodsCode = goodsCode;
        this.profitRatio = profitRatio;
        this.commisions = commisions;
    }

    public int getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(int goodsCode) {
        this.goodsCode = goodsCode;
    }

    public float getProfitRatio() {
        return profitRatio;
    }

    public void setProfitRatio(float profitRatio) {
        this.profitRatio = profitRatio;
    }

    public float getCommisions() {
        return commisions;
    }

    public void setCommisions(float commisions) {
        this.commisions = commisions;
    }
}