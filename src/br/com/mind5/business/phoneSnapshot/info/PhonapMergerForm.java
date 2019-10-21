package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.form.formPhone.info.FormPhoneInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhonapMergerForm extends InfoMergerTemplate<PhonapInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitor<PhonapInfo, FormPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
