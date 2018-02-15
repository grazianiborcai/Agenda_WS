package br.com.gda.resource;

import javax.ws.rs.core.Response.Status;

import br.com.gda.helper.RecordMode;
import br.com.gda.helper.Store;
import br.com.gda.model.JsonBuilder;

final class StoreCheckerUpdate extends StoreCheckerAbstract {
	protected StoreCheckerUpdate() {
		super();
	}
	
	
	@Override protected boolean isRecordModeValidHook(Store store) {
		if (store.getRecordMode().equals(RecordMode.RECORD_OK) ||
			store.getRecordMode().equals(RecordMode.ISUPDATED))
			return true;
			
		this.failMsg = JsonBuilder.ILLEGAL_ARGUMENT;	
		this.failStatus = Status.BAD_REQUEST;
		return false;
	}
	
	
	
	@Override protected boolean isStoreExistHook(Store store) {		
		Store oldStore = tryToSelectStoreFromCodStore(store);
		
		if (oldStore.getCodStore() == null) {
			this.failMsg = JsonBuilder.STORE_NOT_FOUND;
			this.failStatus = Status.BAD_REQUEST;
			return false;
		}
		
		return true;
	}
}
