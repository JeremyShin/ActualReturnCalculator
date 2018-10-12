package my.examples.arc.dto;

public class ArcGdsAddDto {
    private int gdsCd;
    private Long prfRto;
    private float cms;

    public ArcGdsAddDto(int gdsCd, Long prfRto, float cms) {
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

    public Long getPrfRto() {
        return prfRto;
    }

    public void setPrfRto(Long prfRto) {
        this.prfRto = prfRto;
    }

    public float getCms() {
        return cms;
    }

    public void setCms(float cms) {
        this.cms = cms;
    }
}