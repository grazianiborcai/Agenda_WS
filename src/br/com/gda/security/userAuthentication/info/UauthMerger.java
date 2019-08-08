package br.com.gda.security.userAuthentication.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;

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
