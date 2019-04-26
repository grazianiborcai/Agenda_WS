package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;
import br.com.gda.security.username.info.UsernameInfo;

final class StoreMergerUsername extends InfoMerger_<StoreInfo, UsernameInfo, StoreInfo> {
	public StoreInfo merge(UsernameInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeUsername());
	}
	
	
	
	public List<StoreInfo> merge(List<UsernameInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeUsername());
	}
}
