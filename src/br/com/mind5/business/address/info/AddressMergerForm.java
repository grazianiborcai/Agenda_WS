package br.com.mind5.business.address.info;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddressMergerForm extends InfoMergerTemplate_<AddressInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor_<AddressInfo, FormAddressInfo> getVisitorHook() {
		return new AddressVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddressInfo> getUniquifierHook() {
		return new AddressUniquifier();
	}
}
