package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.form.formPhone.info.FormoneInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonapMergerForm extends InfoMergerTemplate_<PhonapInfo, FormoneInfo> {

	@Override protected InfoMergerVisitor_<PhonapInfo, FormoneInfo> getVisitorHook() {
		return new PhonapVisiMergeForm();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
