package br.com.gda.legacy.model;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;

final class StoreCheckerDelete extends StoreCheckerAbstract {
	protected StoreCheckerDelete() {
		super();
	}
	
	
	@Override protected boolean checkRecordModeHook(Store store) {
		if (store.getRecordMode().equals(RecordMode.ISDELETED) ||
			store.getRecordMode().equals(RecordMode.RECORD_DELETED))
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
