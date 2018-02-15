package br.com.gda.resource;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;
import br.com.gda.model.JsonBuilder;

final class StoreCheckerInsert extends StoreCheckerAbstract {
	protected StoreCheckerInsert() {
		super();
	}
	
	
	
	@Override protected boolean isRecordModeValidHook(Store store) {
		if (store.getRecordMode().equals(RecordMode.RECORD_OK) ||
			store.getRecordMode().equals(RecordMode.ISNEW))
			return true;
			
		this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
		this.failStatus = Status.BAD_REQUEST;
		return false;
	}
	
	
	
	@Override protected boolean isMandatoryFieldEmptyHook(Store store) {
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
				return true;
			}
			
			return false;
	}
	
	
	
	@Override protected boolean isStoreExistHook(Store store) {		
		Store selectedStore = tryToSelectStoreFromCnpj(store);
		
		if (selectedStore.getCodStore() != null) {
			this.failMsg = JsonBuilder.STORED_ALREADY_EXIST;
			this.failStatus = Status.FORBIDDEN;
			return false;
		}
		
		return true;
	}
}
