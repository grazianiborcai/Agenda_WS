package br.com.mind5.business.employee.info;

import br.com.mind5.business.address.info.AddressInfo;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class EmpSetterAddressKey implements InfoSetter<EmpInfo> {
	
	public EmpInfo setAttr(EmpInfo recordInfo) {
		checkArgument(recordInfo);
		return setAddressKey(recordInfo);
	}
	
	
	
	private void checkArgument(EmpInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private EmpInfo setAddressKey(EmpInfo recordInfo) {
		for (AddressInfo eachAddress : recordInfo.addresses) {
			eachAddress.codOwner = recordInfo.codOwner;
			eachAddress.codEmployee = recordInfo.codEmployee;
			eachAddress.username = recordInfo.username;
			eachAddress.codLanguage = recordInfo.codLanguage;
			eachAddress.lastChangedBy = recordInfo.lastChangedBy;	//TODO: remover
		}
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
