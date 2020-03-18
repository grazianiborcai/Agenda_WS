package br.com.mind5.business.person.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PersonSetterNameDisplay implements InfoSetter<PersonInfo> {
	
	public PersonInfo setAttr(PersonInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.nameDisplay = recordInfo.name;
		return recordInfo;
	}
	
	
	
	private void checkArgument(PersonInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}	
}
