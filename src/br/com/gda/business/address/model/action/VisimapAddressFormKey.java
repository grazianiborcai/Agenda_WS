package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapAddressFormKey implements ActionVisitorMap<AddressInfo, FormAddressInfo> {	

	@Override public FormAddressInfo buildMapKey(AddressInfo recordInfo) {
		return FormAddressInfo.copyFrom(recordInfo);
	}
}
