package br.com.gda.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import br.com.gda.dao.StoreDAO;
import br.com.gda.helper.Store;

abstract class StoreCheckerAbstract implements StoreChecker {
	protected String failMsg;
	protected Status failStatus;
	
	
	protected StoreCheckerAbstract() {
		this.failMsg = "";
		this.failStatus = Status.OK;
	}
	
	
	@Override public boolean checkOperation(List<Store> stores) {
		if (! checkArgument(stores))
			return false;
		
		
		for (Store eachStore: stores) {
			if (! checkOperation(eachStore))
				return false;
		}
		
		return true;
	}
	
	
	
	private boolean checkArgument(List<Store> stores) {
		if (stores == null || stores.isEmpty()) {
			this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
			this.failStatus = Status.BAD_REQUEST;
			return false;
		}
		
		return true;
	}
	
	
	
	@Override public boolean checkOperation(Store store) {
		if (! checkArgument(store))
			return false;
		
		if (! checkRecordMode(store))
			return false;
		
		if (! checkMandatoryField(store)) 
			return false;
		//TODO: Verificar o RecordMode para saber se o registro é válido
		if (! checkStoreExist(store))
			return false;
		
		if (! checkDependency(store))
			return false;
		
		return checkOperationHook(store);
	}
	
	
	
	private boolean checkArgument(Store store) {
		if (store == null) {
			this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
			this.failStatus = Status.BAD_REQUEST;
			return false;
		}
		
		return true;
	}
	
	
	
	private boolean checkRecordMode(Store store) {
		if (store.getRecordMode() == null)
			return false;
		
		return checkRecordModeHook(store);
	}
	
	
	
	protected boolean checkRecordModeHook(Store store) {
		return true;
	}
	
	
	
	private boolean checkMandatoryField(Store store) {
		return checkMandatoryFieldHook(store);
	}
	
	
	
	protected boolean checkMandatoryFieldHook(Store store) {
		return true;
	}
	
	
	
	private boolean checkStoreExist(Store store) {
		return checkStoreExistHook(store);
	}
	
	
	
	protected boolean checkStoreExistHook(Store newStore) {
		return true;
	}
	
	
	
	private boolean checkDependency(Store store) {
		return checkDependencyHook(store);
	}
	
	
	
	protected boolean checkDependencyHook(Store store) {
		return true;
	}
	
	
	
	protected boolean checkOperationHook(Store store) {
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
