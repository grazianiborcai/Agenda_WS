package br.com.mind5.business.customerSearch.info;

import br.com.mind5.business.masterData.info.common.EntityCateg;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CusarchSetterCodEntityCateg implements InfoSetter<CusarchInfo> {
	
	public CusarchInfo setAttr(CusarchInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(CusarchInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CusarchInfo setCodEntityCateg(CusarchInfo recordInfo) {		
		recordInfo.codEntityCateg = EntityCateg.CUSTOMER.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}	
}
