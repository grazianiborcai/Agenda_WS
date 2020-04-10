package br.com.mind5.business.addressSnapshot.info;

import br.com.mind5.business.form.formAddress.info.FormessInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class AddresnapMergerForm extends InfoMergerTemplate_<AddresnapInfo, FormessInfo> {

	@Override protected InfoMergerVisitor_<AddresnapInfo, FormessInfo> getVisitorHook() {
		return new AddresnapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<AddresnapInfo> getUniquifierHook() {
		return new AddresnapUniquifier();
	}
}
