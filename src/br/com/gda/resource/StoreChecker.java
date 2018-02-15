package br.com.gda.resource;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.Store;


public interface StoreChecker {
	static StoreChecker factory(StoreCheckerOperation opration) {
		return opration.getInstanceOfStoreChecker();
	}
	
	
	
	public boolean isOperationValid(List<Store> stores);
	public String getFailedExplanation();
	public Status getFailedStatus();
}
