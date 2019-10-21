package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class AddresnapMergerForm extends InfoMergerTemplate<AddresnapInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor<AddresnapInfo, FormAddressInfo> getVisitorHook() {
		return new AddresnapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
