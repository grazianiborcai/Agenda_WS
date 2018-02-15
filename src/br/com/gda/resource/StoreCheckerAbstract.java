package br.com.gda.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.gda.dao.StoreDAO;
import br.com.gda.helper.Store;
import br.com.gda.model.JsonBuilder;

abstract class StoreCheckerAbstract implements StoreChecker {
	protected String failMsg;
	protected Status failStatus;
	
	
	protected StoreCheckerAbstract() {
		this.failMsg = "";
		this.failStatus = Status.OK;
	}
	
	
	@Override public boolean isOperationValid(List<Store> stores) {
		if (stores == null)
			return false;
		
		if (stores.isEmpty())
			return false;
		
		for (Store eachStore: stores) {
			if (! isRecordModeValid(eachStore))
				return false;
			
			if (isMandatoryFieldEmpty(eachStore)) 
				return false;
			
			if (! isStoreExist(eachStore))
				return false;
		}
		
		return isOperationValidHook(stores);
	}
	
	
	
	protected boolean isOperationValidHook(List<Store> stores) {
		return true;
	}
	
	
	
	private boolean isRecordModeValid(Store store) {
		if (store.getRecordMode() == null)
			return false;
		
		return isRecordModeValidHook(store);
	}
	
	
	
	protected boolean isRecordModeValidHook(Store store) {
		return true;
	}
	
	
	
	private boolean isMandatoryFieldEmpty(Store store) {
		return isMandatoryFieldEmptyHook(store);
	}
	
	
	
	protected boolean isMandatoryFieldEmptyHook(Store store) {
		return false;
	}
	
	
	
	private boolean isStoreExist(Store store) {
		return isStoreExistHook(store);
	}
	
	
	
	protected boolean isStoreExistHook(Store newStore) {
		return true;
	}
	
	
	
	protected Store tryToSelectStoreFromCodStore(Store store) {
		Store emptyStore = new Store();
		
		try {
			List<Integer> codStores = new ArrayList<>();
			codStores.add(store.getCodStore());
			List<Store> stores = new StoreDAO().selectStoreFromCodStore(store.getCodOwner(), codStores);
			
			if (stores.isEmpty())
				return emptyStore;
			
			Store oneStore = stores.get(0);
			return oneStore;
			
		} catch (SQLException e) {
			this.failMsg = JsonBuilder.INTERNAL_ERROR;
			this.failStatus = Status.INTERNAL_SERVER_ERROR;
			return emptyStore;
		}
	}
	
	
	
	protected Store tryToSelectStoreFromCnpj(Store store) {
		Store emptyStore = new Store();
		
		try {
			List<Store> stores = new StoreDAO().selectStoreFromCnpj(store.getCodOwner(), store.getCnpj());
			
			if (stores.isEmpty())
				return emptyStore;
			
			Store oneStore = stores.get(0);
			return oneStore;
			
		} catch (SQLException e) {
			this.failMsg = JsonBuilder.INTERNAL_ERROR;
			this.failStatus = Status.INTERNAL_SERVER_ERROR;
			return emptyStore;
		}
	}
	
	
	
	@Override public String getFailedExplanation() {
		return this.failMsg;
	}
	
	
	
	@Override public Status getFailedStatus() {
		return this.failStatus;
	}
}
