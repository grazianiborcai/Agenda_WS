package br.com.gda.business.store.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class StoreMergerUser extends InfoMerger<StoreInfo, UserInfo, StoreInfo> {
	public StoreInfo merge(UserInfo sourceOne, StoreInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StoreVisiMergeUser());
	}
	
	
	
	public List<StoreInfo> merge(List<UserInfo> sourceOnes, List<StoreInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StoreVisiMergeUser());
	}
}
