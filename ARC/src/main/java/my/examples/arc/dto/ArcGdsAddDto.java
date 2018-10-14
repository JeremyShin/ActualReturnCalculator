package my.examples.arc.dto;

public class ArcGdsAddDto {
    private int gdsCd;
    private float prfRto;
    private float cms;

    public ArcGdsAddDto(int gdsCd, Float prfRto, float cms) {
        this.gdsCd = gdsCd;
        this.prfRto = prfRto;
        this.cms = cms;
    }

    public int getGdsCd() {
        return gdsCd;
    }

    public void setGdsCd(int gdsCd) {
        this.gdsCd = gdsCd;
    }

    public Float getPrfRto() {
        return prfRto;
    }

    public void setPrfRto(Float prfRto) {
        this.prfRto = prfRto;
    }

    public float getCms() {
        return cms;
    }

    public void setCms(float cms) {
        this.cms = cms;
    }
}