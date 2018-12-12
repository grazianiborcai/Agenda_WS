package br.com.gda.business.addressSnapshot.model.action;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapAddressSnapFormKey implements ActionVisitorMap<AddressSnapInfo, FormAddressInfo> {	

	@Override public FormAddressInfo buildMapKey(AddressSnapInfo recordInfo) {
		return FormAddressInfo.copyFrom(recordInfo);
	}
}
