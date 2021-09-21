
package com.test.rahmasameh.pure.model;

import java.util.List;

 import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.test.rahmasameh.mvvm.model.Support;
import com.test.rahmasameh.mvvm.model.UserDTO;

public class PageDTO  {

   @SerializedName("page")
   @Expose
   private Integer page;
   @SerializedName("per_page")
   @Expose
   private Integer perPage;
   @SerializedName("total")
   @Expose
   private Integer total;
   @SerializedName("total_pages")
   @Expose
   private Integer totalPages;
   @SerializedName("data")
   @Expose
   private List<UserDTO> data = null;
   @SerializedName("support")
   @Expose
   private Support support;

    public PageDTO(Integer page, Integer perPage, Integer total, Integer totalPages, List<UserDTO> data, Support support) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPages = totalPages;
        this.data = data;
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

   public Integer getTotalPages() {
       return totalPages;
   }

   public void setTotalPages(Integer totalPages) {
       this.totalPages = totalPages;
   }

   public List<UserDTO > getData() {
       return data;
   }

   public void setData(List<UserDTO > data) {
       this.data = data;
   }

   public Support getSupport() {
       return support;
   }

   public void setSupport(Support support) {
       this.support = support;
   }

}
