package br.com.mind5.security.username.info;

import java.util.List;

import br.com.mind5.business.masterData.info.AuthGrRoleInfo;
import br.com.mind5.info.InfoMerger;

public final class UsernameMerger {
	public static UsernameInfo mergeWithAuthGrRole(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		InfoMerger<UsernameInfo, AuthGrRoleInfo> merger = new UsernameMergerAuthGrRole();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UsernameInfo> mergeWithAuthGrRole(List<AuthGrRoleInfo> sourceOnes, List<UsernameInfo> sourceTwos) {
		InfoMerger<UsernameInfo, AuthGrRoleInfo> merger = new UsernameMergerAuthGrRole();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UsernameInfo mergeToSelect(UsernameInfo sourceOne, UsernameInfo sourceTwo) {
		InfoMerger<UsernameInfo, UsernameInfo> merger = new UsernameMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UsernameInfo> mergeToSelect(List<UsernameInfo> sourceOnes, List<UsernameInfo> sourceTwos) {
		InfoMerger<UsernameInfo, UsernameInfo> merger = new UsernameMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
