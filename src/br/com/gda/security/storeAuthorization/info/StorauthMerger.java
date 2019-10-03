package br.com.gda.security.storeAuthorization.info;

import java.util.List;

import br.com.gda.business.ownerStore_.info.OwntoreInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class StorauthMerger {
	public static StorauthInfo mergeWithUsername(UsernameInfo sourceOne, StorauthInfo sourceTwo) {
		InfoMerger<StorauthInfo, UsernameInfo> merger = new StorauthMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorauthInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StorauthInfo> sourceTwos) {
		InfoMerger<StorauthInfo, UsernameInfo> merger = new StorauthMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StorauthInfo mergeWithOwntore(OwntoreInfo sourceOne, StorauthInfo sourceTwo) {
		InfoMerger<StorauthInfo, OwntoreInfo> merger = new StorauthMergerOwntore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StorauthInfo> mergeWithOwntore(List<OwntoreInfo> sourceOnes, List<StorauthInfo> sourceTwos) {
		InfoMerger<StorauthInfo, OwntoreInfo> merger = new StorauthMergerOwntore();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
