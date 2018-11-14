package br.com.gda.business.form.formPhone.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

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
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
