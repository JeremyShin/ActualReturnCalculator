package my.examples.arc.dto;

/**
 * paging 처리를위한DTO
 */

public class PagingDTO {
    private int totalCount; //전체카운트.
    private int startPage; //시작하는페이지.
    private int endPage; //끝나는페이지.
    private int presentPage; //현재페이지.
    private int pageSize; //한페이지에 표시할 상품의 갯수.

    public void pagingDTO() {}

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPresentPage() {
        return presentPage;
    }

    public void setPresentPage(int presentPage) {
        this.presentPage = presentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
