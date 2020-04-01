package br.com.mind5.business.materialSearch.info;

import br.com.mind5.business.masterData.info.common.MatCateg;
import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class MatarchSetterMatCategProduct implements InfoSetter<MatarchInfo> {
	
	public MatarchInfo setAttr(MatarchInfo recordInfo) {
		checkArgument(recordInfo);
		return setKey(recordInfo);
	}
	
	
	
	private void checkArgument(MatarchInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private MatarchInfo setKey(MatarchInfo recordInfo) {
		recordInfo.codMatCateg = MatCateg.PRODUCT.getCodMatCateg();		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
