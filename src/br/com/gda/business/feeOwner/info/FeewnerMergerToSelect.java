package br.com.gda.business.feeOwner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;

final class FeewnerMergerToSelect extends InfoMergerTemplate<FeewnerInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor<FeewnerInfo, FeewnerInfo> getVisitorHook() {
		return new FeewnerVisiMergeToSelect();
	}
}
