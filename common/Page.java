package com.ozc.common;

/**
 * 翻页信息对象
 */
public class Page {

	//当前是第几页
	private Integer currentPage = 1;
	
	//每页有多少行
	private Integer rowsPerPage = 6;

	// private Integer startRow = 0;
	
	//总共行数(关键属性，获取总行数即可得到总页数)
	private Integer totalRows = 0;
	//总共页数
	private Integer totalPages = 0;
	
	/**
	 *	 当前页第一条记录在记录总数中是第几条记录
	 */
	public Integer getStartRow() {

		return (currentPage - 1) * rowsPerPage;// +(currentPage.intValue()==1?0:1);
	}
	
	/**
	 *	 设置总的页数
	 */
	public void setTotalPages() {
		this.totalPages = totalRows/rowsPerPage+(totalRows%rowsPerPage == 0?0:1);
	}

	public Integer getTotalPages() {
		return totalPages;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(Integer rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
		setTotalPages();//根据记录总数计算总页数
	}
	/**
	 * 判断是否还有上一页
	 * @return boolean
	 */
	public boolean isHasPrevious() {
		if (currentPage == 1) {
			return false;
		} else {
			return true;
		}
	}
	/**
	 * 判断是否还有下一页
	 * @return boolean
	 */
	public boolean isHasNext() {
		if (totalPages == 1) {
			return false;
		} else {
			if (currentPage < totalPages) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public int getNextPage() {
		return currentPage +1;
	}
	
	public int getPrePage() {
		return currentPage-1;
	}

	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", rowsPerPage="
				+ rowsPerPage + ", totalRows=" + totalRows + ", totalPages="
				+ totalPages + "]";
	}

}
