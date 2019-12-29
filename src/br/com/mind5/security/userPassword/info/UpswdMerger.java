package br.com.mind5.security.userPassword.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.user.info.UserInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UpswdMerger {
	public static UpswdInfo mergeWithUsername(UsernameInfo sourceOne, UpswdInfo sourceTwo) {
		InfoMerger<UpswdInfo, UsernameInfo> merger = new UpswdMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UpswdInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<UpswdInfo> sourceTwos) {
		InfoMerger<UpswdInfo, UsernameInfo> merger = new UpswdMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UpswdInfo mergeWithUser(UserInfo sourceOne, UpswdInfo sourceTwo) {
		InfoMerger<UpswdInfo, UserInfo> merger = new UpswdMergerUser();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UpswdInfo> mergeWithUser(List<UserInfo> sourceOnes, List<UpswdInfo> sourceTwos) {
		InfoMerger<UpswdInfo, UserInfo> merger = new UpswdMergerUser();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UpswdInfo mergeToAuth(UpswdInfo sourceOne, UpswdInfo sourceTwo) {
		InfoMerger<UpswdInfo, UpswdInfo> merger = new UpswdMergerToAuth();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UpswdInfo> mergeToAuth(List<UpswdInfo> sourceOnes, List<UpswdInfo> sourceTwos) {
		InfoMerger<UpswdInfo, UpswdInfo> merger = new UpswdMergerToAuth();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
