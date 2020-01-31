package br.com.mind5.business.store.info;

import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class StoreMergerFimist extends InfoMergerTemplate_<StoreInfo, FimistInfo> {

	@Override protected InfoMergerVisitor_<StoreInfo, FimistInfo> getVisitorHook() {
		return new StoreVisiMergeFimist();
	}
	
	
	
	@Override protected InfoUniquifier<StoreInfo> getUniquifierHook() {
		return new StoreUniquifier();
	}
}
