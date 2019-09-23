package br.com.gda.business.phoneSearch.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class PhonarchMergerToSelect extends InfoMergerTemplate<PhonarchInfo, PhonarchInfo> {

	@Override protected InfoMergerVisitor<PhonarchInfo, PhonarchInfo> getVisitorHook() {
		return new PhonarchVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<PhonarchInfo> getUniquifierHook() {
		return new PhonarchUniquifier();
	}
}
