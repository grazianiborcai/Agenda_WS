package br.com.gda.business.address.model.action;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.business.form.info.AddressFormInfo;
import br.com.gda.model.action.ActionVisitorMap;

public final class VisimapAddressFormKey implements ActionVisitorMap<AddressInfo, AddressFormInfo> {	

	@Override public AddressFormInfo buildMapKey(AddressInfo recordInfo) {
		return AddressFormInfo.copyFrom(recordInfo);
	}
}
