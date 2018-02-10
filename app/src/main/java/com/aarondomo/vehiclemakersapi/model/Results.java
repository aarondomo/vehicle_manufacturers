package com.aarondomo.vehiclemakersapi.model;


        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("Count")
    @Expose
    private Integer count;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("SearchCriteria")
    @Expose
    private Object searchCriteria;
    @SerializedName("Results")
    @Expose
    private List<Maker> makers = null;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(Object searchCriteria) {
        this.searchCriteria = searchCriteria;
    }

    public List<Maker> getMakers() {
        return makers;
    }

    public void setMakers(List<Maker> makers) {
        this.makers = makers;
    }

}
