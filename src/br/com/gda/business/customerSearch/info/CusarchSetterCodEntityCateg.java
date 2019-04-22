package br.com.gda.business.customerSearch.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.EntityCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
