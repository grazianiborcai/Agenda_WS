package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class CrecardMergerToSelect extends InfoMergerTemplate<CrecardInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor<CrecardInfo, CrecardInfo> getVisitorHook() {
		return new CrecardVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
