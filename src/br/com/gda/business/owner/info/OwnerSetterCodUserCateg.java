package br.com.gda.business.owner.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.business.masterData.info.common.UserCateg;
import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class OwnerSetterCodUserCateg implements InfoSetter<OwnerInfo> {
	
	public OwnerInfo setAttr(OwnerInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodUserCateg(recordInfo);
	}
	
	
	
	private void checkArgument(OwnerInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private OwnerInfo setCodUserCateg(OwnerInfo recordInfo) {
		recordInfo.codUserCategory = UserCateg.OWNER.getCodUserCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
