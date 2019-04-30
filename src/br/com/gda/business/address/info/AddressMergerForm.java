package br.com.gda.business.address.info;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerForm extends InfoMergerTemplate<AddressInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitorV2<AddressInfo, FormAddressInfo> getVisitorHook() {
		return new AddressVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
