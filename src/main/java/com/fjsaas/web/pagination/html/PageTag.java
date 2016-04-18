package com.fjsaas.web.pagination.html;

import com.fjsaas.web.pagination.Pager;

public interface PageTag  {

	public abstract String generate(String url,String params,Pager pager);
	
}
