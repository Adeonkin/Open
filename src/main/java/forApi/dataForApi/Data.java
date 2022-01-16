package forApi.dataForApi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    private Integer page;
    @JsonProperty("per_page")
    private Integer perPage;
    private Integer total;
    @JsonProperty("total_pages")
    private Integer totalPages;
    private List<UserData> data;
    private Support support;


    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return totalPages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.totalPages = total_pages;
    }

    public List<UserData> getData() {
        return data;
    }

    public void setData(List<UserData> data) {
        this.data = data;
    }

}
