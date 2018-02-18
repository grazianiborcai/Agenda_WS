package br.com.gda.model;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;

final class StoreCheckerUpdate extends StoreCheckerAbstract {
	protected StoreCheckerUpdate() {
		super();
	}
	
	
	@Override protected boolean checkRecordModeHook(Store store) {
		if (store.getRecordMode().equals(RecordMode.RECORD_OK) ||
			store.getRecordMode().equals(RecordMode.ISUPDATED))
			return true;
			
		this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
		this.failStatus = Status.BAD_REQUEST;
		return false;
	}
	
	
	
	@Override protected boolean checkStoreExistHook(Store store) {		
		Store oldStore = tryToSelectStoreFromCodStore(store);
		
		if (oldStore.getCodStore() == null) {
			this.failMsg = JsonBuilder.STORE_NOT_FOUND;
			this.failStatus = Status.BAD_REQUEST;
			return false;
		}
		
		return true;
	}
}
