package br.com.gda.business.form.formAddress.info;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class FormAddressSetterDefault implements InfoSetter<FormAddressInfo> {
	
	public FormAddressInfo setAttr(FormAddressInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codForm = getDefaultForm();
		return recordInfo;
	}
	
	
	
	private void checkArgument(FormAddressInfo recordInfo) {
		if (recordInfo == null) {
			logException(new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT));
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
		}
	}
	
	
	
	private String getDefaultForm() {
		return "A00";
	}
	
	
	
	private void logException(Exception e) {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.error(e.getMessage(), e);
	}
}
