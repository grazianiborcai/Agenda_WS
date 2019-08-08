package br.com.gda.business.address.info;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddressMergerForm extends InfoMergerTemplate<AddressInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, FormAddressInfo> getVisitorHook() {
		return new AddressVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
