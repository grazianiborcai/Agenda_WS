package br.com.mind5.business.address.info;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddressMergerForm extends InfoMergerTemplate<AddressInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor<AddressInfo, FormAddressInfo> getVisitorHook() {
		return new AddressVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
