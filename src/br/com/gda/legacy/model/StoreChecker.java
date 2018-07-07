package br.com.gda.legacy.model;

import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.Store;


public interface StoreChecker {
	static StoreChecker factory(StoreCheckerOperation opration) {
		return opration.getInstanceOfStoreChecker();
	}
	
	
	
	public boolean checkOperation(List<Store> stores);
	public boolean checkOperation(Store store);
	public String getFailedExplanation();
	public Status getFailedStatus();
}
