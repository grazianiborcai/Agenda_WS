package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapMergerForm extends InfoMergerTemplate_<PhonapInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitor_<PhonapInfo, FormPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
