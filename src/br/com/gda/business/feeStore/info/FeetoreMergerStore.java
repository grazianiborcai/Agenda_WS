package br.com.gda.business.feeStore.info;

import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;

final class FeetoreMergerStore extends InfoMergerTemplate<FeetoreInfo, StoreInfo> {

	@Override protected InfoMergerVisitorV2<FeetoreInfo, StoreInfo> getVisitorHook() {
		return new FeetoreVisiMergeStore();
	}
}
