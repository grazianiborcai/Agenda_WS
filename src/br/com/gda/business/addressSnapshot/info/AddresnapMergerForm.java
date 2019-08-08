package br.com.gda.business.addressSnapshot.info;

import br.com.gda.business.form.formAddress.info.FormAddressInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class AddresnapMergerForm extends InfoMergerTemplate<AddresnapInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor<AddresnapInfo, FormAddressInfo> getVisitorHook() {
		return new AddresnapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
