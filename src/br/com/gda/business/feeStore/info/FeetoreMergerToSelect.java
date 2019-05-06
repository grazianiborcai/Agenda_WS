package br.com.gda.business.feeStore.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeetoreMergerToSelect extends InfoMergerTemplate<FeetoreInfo, FeetoreInfo> {

	@Override protected InfoMergerVisitorV2<FeetoreInfo, FeetoreInfo> getVisitorHook() {
		return new FeetoreVisiMergeToSelect();
	}
}
