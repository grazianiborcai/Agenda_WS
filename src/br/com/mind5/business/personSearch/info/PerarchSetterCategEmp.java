package br.com.mind5.business.personSearch.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;
import br.com.mind5.masterData.entityCategory.info.Entiteg;

public final class PerarchSetterCategEmp implements InfoSetter<PerarchInfo> {
	
	public PerarchInfo setAttr(PerarchInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(PerarchInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PerarchInfo setCodEntityCateg(PerarchInfo recordInfo) {
		recordInfo.codEntityCateg = Entiteg.EMPLOYEE.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
