package br.com.mind5.business.person.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PersonSetterBirthdate implements InfoSetter<PersonInfo> {
	
	public PersonInfo setAttr(PersonInfo recordInfo) {
		checkArgument(recordInfo);
		return setCodEntityCateg(recordInfo);
	}
	
	
	
	private void checkArgument(PersonInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private PersonInfo setCodEntityCateg(PersonInfo recordInfo) {
		if (recordInfo.birthDate == null)
			return recordInfo;
		
		
		recordInfo.birthYear = recordInfo.birthDate.getYear();
		recordInfo.birthMonth = recordInfo.birthDate.getMonthValue();
		recordInfo.birthDay = recordInfo.birthDate.getDayOfMonth();
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
