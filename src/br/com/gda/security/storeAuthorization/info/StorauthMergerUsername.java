package br.com.gda.security.storeAuthorization.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class StorauthMergerUsername extends InfoMerger<StorauthInfo, UsernameInfo, StorauthInfo> {
	public StorauthInfo merge(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new StorauthVisiMergeUsername());
	}
	
	
	
	public List<StorauthInfo> merge(List<UsernameInfo> sourceOnes, List<StorauthInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new StorauthVisiMergeUsername());
	}
}
