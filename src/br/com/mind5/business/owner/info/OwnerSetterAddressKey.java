package br.com.mind5.business.owner.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class OwnerSetterAddressKey implements InfoSetter<OwnerInfo> {
	
	public OwnerInfo setAttr(OwnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnerInfo setAddressKey(OwnerInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codOwnerRef = recordInfo.codOwner;
			eachAddress.codLanguage = recordInfo.codLanguage;
			eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
			eachAddress.username = recordInfo.username;
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
