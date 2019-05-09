package br.com.gda.security.userAuthentication.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

public final class UauthMerger {
	public static UauthInfo mergeWithUser(UserInfo sourceOne, UauthInfo sourceTwo) {
		InfoMerger<UauthInfo, UserInfo> merger = new UauthMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UauthInfo> mergeWithUser(List<UserInfo> sourceOnes, List<UauthInfo> sourceTwos) {
		InfoMerger<UauthInfo, UserInfo> merger = new UauthMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
