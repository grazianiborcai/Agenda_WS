package br.com.gda.security.storeAuthorization.info;

import java.util.List;

import br.com.gda.business.ownerStore.info.OwntoreInfo;
import br.com.gda.info.InfoMerger;

final class StorauthMergerOwntore extends InfoMerger<StorauthInfo, OwntoreInfo, StorauthInfo> {
	public StorauthInfo merge(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StorauthVisiMergeOwntore());
	}
	
	
	
	public List<StorauthInfo> merge(List<OwntoreInfo> sourceOnes, List<StorauthInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StorauthVisiMergeOwntore());
	}
}
