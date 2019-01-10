package br.com.gda.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.EntityCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OwnerSetterCodEntityCateg implements InfoSetter<OwnerInfo> {
	
	public OwnerInfo setAttr(OwnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnerInfo setCodEntityCateg(OwnerInfo recordInfo) {
		recordInfo.codEntityCateg = EntityCateg.OWNER.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
