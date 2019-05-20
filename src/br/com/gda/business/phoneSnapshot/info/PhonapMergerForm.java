package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.form.formPhone.info.FormPhoneInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class PhonapMergerForm extends InfoMergerTemplate<PhonapInfo, FormPhoneInfo> {

	@Override protected InfoMergerVisitorV2<PhonapInfo, FormPhoneInfo> getVisitorHook() {
		return new PhonapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
