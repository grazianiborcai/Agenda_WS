package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.form.formAddress.info.FormAddressInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapMergerForm extends InfoMergerTemplate_<AddresnapInfo, FormAddressInfo> {

	@Override protected InfoMergerVisitor_<AddresnapInfo, FormAddressInfo> getVisitorHook() {
		return new AddresnapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
