package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.user.info.UserInfo;

public final class UpswdMerger {
	public static UpswdInfo mergeWithUser(UserInfo sourceOne, UpswdInfo sourceTwo) {
		InfoMerger<UpswdInfo, UserInfo> merger = new UpswdMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UpswdInfo> mergeWithUser(List<UserInfo> sourceOnes, List<UpswdInfo> sourceTwos) {
		InfoMerger<UpswdInfo, UserInfo> merger = new UpswdMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
