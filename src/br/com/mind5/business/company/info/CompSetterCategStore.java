package br.com.mind5.business.company.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.EntityCateg;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class CompSetterCategStore implements InfoSetter<CompInfo> {
	
	public CompInfo setAttr(CompInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(CompInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private CompInfo setCodEntityCateg(CompInfo recordInfo) {
		recordInfo.codEntityCateg = EntityCateg.STORE.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
