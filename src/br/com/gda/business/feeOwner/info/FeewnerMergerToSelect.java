package br.com.gda.business.feeOwner.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeewnerMergerToSelect extends InfoMergerTemplate<FeewnerInfo, FeewnerInfo> {

	@Override protected InfoMergerVisitorV2<FeewnerInfo, FeewnerInfo> getVisitorHook() {
		return new FeewnerVisiMergeToSelect();
	}
}
