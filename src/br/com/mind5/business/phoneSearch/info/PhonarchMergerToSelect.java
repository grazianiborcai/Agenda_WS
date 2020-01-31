package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class PhonarchMergerToSelect extends InfoMergerTemplate_<PhonarchInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor_<PhonarchInfo, PhonarchInfo> getVisitorHook() {
		return new PhonarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhonarchInfo> getUniquifierHook() {
		return new PhonarchUniquifier();
	}
}
