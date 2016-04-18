package com.fjsaas.web.pagination;

import java.util.List;

import com.fjsaas.web.pagination.html.PageTag;

public class Pager {

	private List<?> list; //对象记录结果集
    private int total = 0; // 总记录数
    private int pageSize = 10; // 每页显示记录数
    private int pages = 1; // 总页数
  
    private int pageNo = 1; // 当前页
    
    private String url;//分页地址
    private String params;//分页参数
    private String pageView;//生成分页HTML
     
    private boolean isFirstPage=false;        //是否为第一页
    private boolean isLastPage=false;         //是否为最后一页
    private boolean hasPreviousPage=false;   //是否有前一页
    private boolean hasNextPage=false;       //是否有下一页
     
    private int navigatePages=8; //导航页码数
    private int[] navigatePageNumbers;  //所有导航页号
     
    public Pager(int pageNo , int total) {
        init(total, pageNo, pageSize);
    }
     
    public Pager(int pageNo, int pageSize ,int total ) {
        init(total, pageNo, pageSize);
    }
     
    private void init(int total, int pageNumber, int limit){
        //设置基本参数
        this.total=total;
        this.pageSize=limit;
        this.pages=(this.total-1)/this.pageSize+1;
         
        //根据输入可能错误的当前号码进行自动纠正
        if(pageNumber<1){
            this.pageNo=1;
        }else if(pageNumber>this.pages){
            this.pageNo=this.pages;
        }else{
            this.pageNo=pageNumber;
        }
         
        //基本参数设定之后进行导航页面的计算
        calcNavigatePageNumbers();
         
        //以及页面边界的判定
        judgePageBoudary();
    }
     
    /**
     * 计算导航页
     */
    private void calcNavigatePageNumbers(){
        //当总页数小于或等于导航页码数时
        if(pages<=navigatePages){
            navigatePageNumbers=new int[pages];
            for(int i=0;i<pages;i++){
                navigatePageNumbers[i]=i+1;
            }
        }else{ //当总页数大于导航页码数时
            navigatePageNumbers=new int[navigatePages];
            int startNum=pageNo-navigatePages/2;
            int endNum=pageNo+navigatePages/2;
             
            if(startNum<1){
                startNum=1;
                //(最前navPageCount页
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
            }else if(endNum>pages){
                endNum=pages;
                //最后navPageCount页
                for(int i=navigatePages-1;i>=0;i--){
                    navigatePageNumbers[i]=endNum--;
                }
            }else{
                //所有中间页
                for(int i=0;i<navigatePages;i++){
                    navigatePageNumbers[i]=startNum++;
                }
            }
        }
    }
 
    /**
     * 判定页面边界
     */
    private void judgePageBoudary(){
        isFirstPage = pageNo == 1;
        isLastPage = pageNo == pages && pageNo!=1;
        hasPreviousPage = pageNo!=1;
        hasNextPage = pageNo!=pages;
    }
     
     
    public void setList(List<?> list) {
        this.list = list;
    }
 
    /**
     * 得到当前页的内容
     * @return {List}
     */
    public List<?> getList() {
        return list;
    }
 
    /**
     * 得到记录总数
     * @return {int}
     */
    public int getTotal() {
        return total;
    }
 
    /**
     * 得到每页显示多少条记录
     * @return {int}
     */
    public int getPageSize() {
        return pageSize;
    }
 
    /**
     * 得到页面总数
     * @return {int}
     */
    public int getPages() {
        return pages;
    }
 
    /**
     * 得到当前页号
     * @return {int}
     */
    public int getPageNo() {
		return pageNo;
	}
 
 
    /**
     * 得到所有导航页号 
     * @return {int[]}
     */
    public int[] getNavigatePageNumbers() {
        return navigatePageNumbers;
    }

	public boolean isFirstPage() {
        return isFirstPage;
    }
 
    public boolean isLastPage() {
        return isLastPage;
    }
 
    public boolean hasPreviousPage() {
        return hasPreviousPage;
    }
 
    public boolean hasNextPage() {
        return hasNextPage;
    }
    
    //<div class='digg'>
    //<span class='disabled'> < </span>
    //<span class='current'>1</span>
    //<a href='#'>2</a>
    //<a href='#'>3</a>
    //<a href='#'>4</a>
    //<a href='#'>5</a>
    //<a href='#'>6</a>
    //<a href='#'>7</a>
    //...<a href='#'>199</a>
    //<a href='#'>200</a>
    //<a href='#'> > </a>
    //</div>
 
    public void pageView(String url,String params){
    	this.url = url;
    	String pageNoUrl = url + "?pageNo=";
    	this.params = params;
    	String tmpStr = "";
    	if(params != null && !"".equals(params)){
    		tmpStr = "&" + params;
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append("<div class='page'>").append("");
    	if(this.isFirstPage){
    		sb.append("<span class='disabled'>首页</span>");
    	}else{
    		sb.append("<a href='" + pageNoUrl +"1" + tmpStr +"'>首页</a>");
    	}
    	if(!this.hasPreviousPage){
    		sb.append("<span class='disabled'>上一页</span>");
    	}else{
    		int tmp = 1;
    		if(this.pageNo > 1){
    			tmp = pageNo - 1;
    		}
    		sb.append("<a href='" + pageNoUrl + String.valueOf(tmp) + tmpStr +"'>上一页</a>");
    	}
    	
    	for (int i = 0; i < navigatePageNumbers.length; i++) {
    		if(this.pageNo == navigatePageNumbers[i]){
    			sb.append("<span class='current'>"+navigatePageNumbers[i]+"</span>");
    		}else{
    			sb.append("<a href='" + pageNoUrl + String.valueOf(navigatePageNumbers[i]) + tmpStr +"'>"+navigatePageNumbers[i]+"</a>");
    		}
		}
    	
    	
    	if(!this.hasNextPage){
    		sb.append("<span class='disabled'>下一页</span>");
    	}else{
    		int tmp = pages;
    		if(this.pageNo < pages){
    			tmp = pageNo + 1;
    		}
    		sb.append("<a href='" + pageNoUrl + String.valueOf(tmp) + tmpStr +"'>下一页</a>");
    	}
    	
    	if(!this.isLastPage){
    		sb.append("<span class='disabled'>尾页</span>");
    	}else{
    		sb.append("<a href='" + pageNoUrl + String.valueOf(this.pages) + tmpStr +"'>尾页</a>");
    	}
    	sb.append("&nbsp;&nbsp;<span>共"+this.pages+"页</span>");
    	sb.append("</div>");
    	this.pageView = sb.toString();
    }
    
    public void pageView(String url,String params,PageTag pageTag){
    	this.pageView = pageTag.generate(url, params,this);
    }
    
    
    public String getPageView() {
		return pageView;
	}

	public String toString(){
        String str=new String();
        str= "[" +
            "total="+total+
            ",pages="+pages+
            ",pageNo="+pageNo+
            ",pageSize="+pageSize+
            //",navigatePages="+navigatePages+
            ",isFirstPage="+isFirstPage+
            ",isLastPage="+isLastPage+
            ",hasPreviousPage="+hasPreviousPage+
            ",hasNextPage="+hasNextPage+
            ",navigatePageNumbers=";
        int len=navigatePageNumbers.length;
        if(len>0)str+=(navigatePageNumbers[0]);
        for(int i=1;i<len;i++){
            str+=(" "+navigatePageNumbers[i]);
        }
        //sb+=",list="+list;
        str+="]";
        return str;
    }

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	public void setNavigatePageNumbers(int[] navigatePageNumbers) {
		this.navigatePageNumbers = navigatePageNumbers;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	
	
	
	
}
