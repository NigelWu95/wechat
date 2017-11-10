/**
 * Project Name: wechat
 * File Name: Page.java
 * Package Name: wechat: com.wechat.beans
 * Copyright (c) 2017, wubingheng  All Rights Reserved.
 */
package com.wechat.beans;

/**
 * ClassName: Page Description: TODO Date Time: 2017年8月8日 下午4:34:26
 * 
 * @author Nigel Wu wubinghengajw@outlook.com
 * @version V1.0
 * @since V1.0
 * @jdk 1.7
 * @see */
public class Page {

    private int currentPage;
    private int pageSize;
    private int itemsTotal;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(int itemsTotal) {
        this.itemsTotal = itemsTotal;
    }
}