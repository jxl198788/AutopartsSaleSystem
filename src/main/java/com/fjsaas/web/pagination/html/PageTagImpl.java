package com.fjsaas.web.pagination.html;

import com.fjsaas.web.pagination.Pager;


public class PageTagImpl implements PageTag {

	/**
	 * <ul class='pagination'>
        	<li class='paginate_button previous disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>Previous</a></li>
        	<li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="#">1</a></li>
        	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">2</a></li>
        	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">3</a></li>
        	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">4</a></li>
        	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">5</a></li>
        	<li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">6</a></li>
        	<li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Next</a></li>
      </ul>
	 */
	@Override
	public String generate(String url, String params,Pager pager) {
		pager.setUrl(url);
		pager.setParams(params);
    	String pageNoUrl = url + "?pageNo=";
    	String tmpStr = "";
    	if(params != null && !"".equals(params)){
    		tmpStr = "&" + params;
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append("<ul class='pagination'>").append("");
    	if(pager.isFirstPage()){
    		sb.append("<li class='paginate_button previous disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>首页</a></li>");
    	}else{
    		sb.append("<li class='paginate_button previous' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='" + pageNoUrl +"1" + tmpStr +"'>首页</a></li>");
    	}
    	if(!pager.hasPreviousPage()){
    		sb.append("<li class='paginate_button previous disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>上一页</a></li>");
    	}else{
    		int tmp = 1;
    		if(pager.getPageNo() > 1){
    			tmp = pager.getPageNo() - 1;
    		}
    		sb.append("<li class='paginate_button previous' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='" + pageNoUrl + String.valueOf(tmp) + tmpStr +"'>上一页</a></li>");
    	}
    	
    	int[] navigatePageNumbers = pager.getNavigatePageNumbers();
    	for (int i = 0; i < navigatePageNumbers.length; i++) {
    		if(pager.getPageNo() == navigatePageNumbers[i]){
    			sb.append("<li class='paginate_button active' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>"+navigatePageNumbers[i]+"</a></li>");
    			//sb.append("<span class='current'>"+navigatePageNumbers[i]+"</span>");
    		}else{
    			sb.append("<li class='paginate_button' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='" + pageNoUrl + String.valueOf(navigatePageNumbers[i]) + tmpStr +"'>"+navigatePageNumbers[i]+"</a></li>");
    		}
		}
    	
    	int pages = pager.getPages();
    	if(!pager.hasNextPage()){
    		sb.append("<li class='paginate_button next disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>下一页</a></li>");
    		//sb.append("<span class='disabled'>下一页</span>");
    	}else{
    		int tmp = pages;
    		if(pager.getPageNo() < pages){
    			tmp = pager.getPageNo() + 1;
    		}
    		sb.append("<li class='paginate_button next' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='" + pageNoUrl + String.valueOf(tmp) + tmpStr +"'>下一页</a></li>");
    	}
    	
    	if(pager.isLastPage()){
    		sb.append("<li class='paginate_button next disabled' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='#'>尾页</a></li>");
    	}else{
    		sb.append("<li class='paginate_button next' aria-controls='dataTables-example' tabindex='0' id='dataTables-example_previous'><a href='" + pageNoUrl + String.valueOf(pages) + tmpStr +"'>尾页</a></li>");
    	}
    	sb.append("</ul>");
    	//sb.append("&nbsp;&nbsp;<span>共"+pages+"页</span>");
    	return sb.toString();
	}

}
