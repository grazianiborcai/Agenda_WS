package br.com.mind5.business.personSearch.info;

import java.text.Normalizer;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class PerarchSetterNameSearch implements InfoSetter<PerarchInfo> {
	
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
		if (recordInfo.name == null)
			return recordInfo;
		
		
		recordInfo.nameSearch = recordInfo.name.toUpperCase();
		recordInfo.nameSearch = Normalizer.normalize(recordInfo.nameSearch, Normalizer.Form.NFD);
		recordInfo.nameSearch = recordInfo.nameSearch.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		
		return recordInfo;
	}
	
	
	
	private void logException(Exception e) {
		
		SystemLog.logError(this.getClass(), e);
	}	
}
