package br.com.gda.payment.creditCard.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class CrecardMergerToSelect extends InfoMergerTemplate<CrecardInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, CrecardInfo> getVisitorHook() {
		return new CrecardVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
