package br.com.gda.business.store.info;

import br.com.gda.file.fileImageList.info.FimistInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class StoreMergerFimist extends InfoMergerTemplate<StoreInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, FimistInfo> getVisitorHook() {
		return new StoreVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
