package br.com.mind5.security.storeAuthorization.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StorauthMerger {
	public static StorauthInfo mergeWithUsername(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		InfoMerger_<StorauthInfo, UsernameInfo> merger = new StorauthMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorauthInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StorauthInfo> sourceTwos) {
		InfoMerger_<StorauthInfo, UsernameInfo> merger = new StorauthMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorauthInfo mergeToSelect(StorauthInfo sourceOne, StorauthInfo sourceTwo) {
		InfoMerger_<StorauthInfo, StorauthInfo> merger = new StorauthMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorauthInfo> mergeToSelect(List<StorauthInfo> sourceOnes, List<StorauthInfo> sourceTwos) {
		InfoMerger_<StorauthInfo, StorauthInfo> merger = new StorauthMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
