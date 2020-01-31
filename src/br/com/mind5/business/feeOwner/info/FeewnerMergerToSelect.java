package br.com.mind5.business.feeOwner.info;

import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class FeewnerMergerToSelect extends InfoMergerTemplate_<FeewnerInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor_<FeewnerInfo, FeewnerInfo> getVisitorHook() {
		return new FeewnerVisiMergeToSelect();
	}
}
