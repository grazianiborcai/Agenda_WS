package br.com.mind5.business.phoneSearch.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class PhonarchMergerToSelect extends InfoMergerTemplate<PhonarchInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor<PhonarchInfo, PhonarchInfo> getVisitorHook() {
		return new PhonarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhonarchInfo> getUniquifierHook() {
		return new PhonarchUniquifier();
	}
}
