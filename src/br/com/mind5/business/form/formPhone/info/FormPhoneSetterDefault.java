package br.com.mind5.business.form.formPhone.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

public final class FormPhoneSetterDefault implements InfoSetter<FormPhoneInfo> {
	
	public FormPhoneInfo setAttr(FormPhoneInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codForm = getDefaultForm();
		return recordInfo;
	}
	
	
	
	private void checkArgument(FormPhoneInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private String getDefaultForm() {
		return "T00";
	}
	
	
	
	private void logException(Exception e) {
		SystemLog.logError(this.getClass(), e);
	}
}
