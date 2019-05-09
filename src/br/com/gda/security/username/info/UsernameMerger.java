package br.com.gda.security.username.info;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMerger;

public final class UsernameMerger {
	public static UsernameInfo mergeWithAuthGrRole(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		InfoMerger<UsernameInfo, AuthGrRoleInfo> merger = new UsernameMergerAuthGrRole();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UsernameInfo> mergeWithAuthGrRole(List<AuthGrRoleInfo> sourceOnes, List<UsernameInfo> sourceTwos) {
		InfoMerger<UsernameInfo, AuthGrRoleInfo> merger = new UsernameMergerAuthGrRole();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
