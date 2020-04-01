package br.com.mind5.business.form.formAddress.info;

import br.com.mind5.common.SystemLog;
import br.com.mind5.common.SystemMessage;
import br.com.mind5.info.InfoSetter;

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
		SystemLog.logError(this.getClass(), e);
	}
}
