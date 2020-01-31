package br.com.mind5.payment.creditCard.info;

import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class CrecardMergerToDelete extends InfoMergerTemplate_<CrecardInfo, CrecardInfo> {

	@Override protected InfoMergerVisitor_<CrecardInfo, CrecardInfo> getVisitorHook() {
		return new CrecardVisiMergeToDelete();
	}
	
	
	
	@Override protected InfoUniquifier<CrecardInfo> getUniquifierHook() {
		return new CrecardUniquifier();
	}
}
