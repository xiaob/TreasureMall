package com.union.beiqi.service.api;

import org.json.JSONObject;

import com.union.beiqi.base.annotation.HttpRequest;
import com.union.beiqi.service.entity.GameBean;

public interface IHttpService
{
	@HttpRequest(arguments = { "" }, resultClass = GameBean.class, refreshMethod = "refreshGames")
	public void getAllGameList(Object context);
	
	@HttpRequest(arguments = { "clientPasswrod","clientLoginName"}, resultClass =JSONObject.class, refreshMethod = "clientLogin")
	public void clientLogin(Object context,String  clientPasswrod ,String clientLoginName);
}
