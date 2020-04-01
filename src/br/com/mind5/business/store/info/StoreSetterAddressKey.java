package br.com.mind5.business.store.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class StoreSetterAddressKey implements InfoSetter<StoreInfo> {
	
	public StoreInfo setAttr(StoreInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(StoreInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private StoreInfo setAddressKey(StoreInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codStore = recordInfo.codStore;
			eachAddress.username = recordInfo.username;
			eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
			eachAddress.codLanguage = recordInfo.codLanguage;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
