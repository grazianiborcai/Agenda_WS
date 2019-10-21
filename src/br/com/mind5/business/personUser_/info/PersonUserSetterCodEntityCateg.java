package br.com.mind5.business.personUser_.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.business.masterData.info.common.EntityCateg;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PersonUserSetterCodEntityCateg implements InfoSetter<PersonUserInfo> {
	
	public PersonUserInfo setAttr(PersonUserInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(PersonUserInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PersonUserInfo setCodEntityCateg(PersonUserInfo recordInfo) {
		recordInfo.codEntityCateg = EntityCateg.USER.getCodEntityCateg();
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
