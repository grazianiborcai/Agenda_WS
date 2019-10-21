package br.com.mind5.business.store.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class StoreMergerFimist extends InfoMergerTemplate<StoreInfo, FimistInfo> {

	@Override protected InfoMergerVisitor<StoreInfo, FimistInfo> getVisitorHook() {
		return new StoreVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
