package br.com.gda.legacy.model;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;

final class StoreCheckerInsert extends StoreCheckerAbstract {
	protected StoreCheckerInsert() {
		super();
	}
	
	
	
	@Override protected boolean checkRecordModeHook(Store store) {
		if (store.getRecordMode().equals(RecordMode.RECORD_OK) ||
			store.getRecordMode().equals(RecordMode.ISNEW))
			return true;
			
		this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
		this.failStatus = Status.BAD_REQUEST;
		return false;
	}
	
	
	
	@Override protected boolean checkMandatoryFieldHook(Store store) {
		if (store.getAddress1() 	== null ||
			store.getAddress2() 	== null ||
			store.getCity() 		== null ||
			store.getState() 		== null ||
			store.getCnpj() 		== null ||
			store.getCodOwner() 	== null ||
			store.getCountry() 		== null ||
			store.getName() 		== null ||
			store.getPhone() 		== null ||
			store.getPostalcode() 	== null ||
			store.getRazaoSocial() 	== null) {
			
			this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;
			this.failStatus = Status.BAD_REQUEST;
			return false;
		}
		
		return true;
	}
	
	
	
	@Override protected boolean checkStoreExistHook(Store store) {		
		Store selectedStore = tryToSelectStoreFromCnpj(store);
		
		if (selectedStore.getCodStore() != null) {
			this.failMsg = JsonBuilder.STORED_ALREADY_EXIST;
			this.failStatus = Status.FORBIDDEN;
			return false;
		}
		
		return true;
	}
}
