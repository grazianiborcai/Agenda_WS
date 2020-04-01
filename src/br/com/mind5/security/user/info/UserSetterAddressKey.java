package br.com.mind5.security.user.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class UserSetterAddressKey implements InfoSetter<UserInfo> {
	
	public UserInfo setAttr(UserInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(UserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private UserInfo setAddressKey(UserInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codUser = recordInfo.codUser;
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
