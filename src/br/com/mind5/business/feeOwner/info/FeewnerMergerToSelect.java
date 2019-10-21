package br.com.mind5.business.feeOwner.info;

import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;

final class FeewnerMergerToSelect extends InfoMergerTemplate<FeewnerInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitor<FeewnerInfo, FeewnerInfo> getVisitorHook() {
		return new FeewnerVisiMergeToSelect();
	}
}
