package br.com.gda.business.form.info;

import br.com.gda.common.SystemMessage;
import br.com.gda.info.InfoSetter;

public final class AddressFormSetterDefault implements InfoSetter<AddressFormInfo> {
	
	public AddressFormInfo setAttr(AddressFormInfo recordInfo) {
		checkArgument(recordInfo);
		
		recordInfo.codForm = getDefaultForm();
		return recordInfo;
	}
	
	
	
	private void checkArgument(AddressFormInfo recordInfo) {
		if (recordInfo == null)
			throw new NullPointerException("recordInfo" + SystemMessage.NULL_ARGUMENT);
	}
	
	
	
	private String getDefaultForm() {
		return "A00";
	}
}
