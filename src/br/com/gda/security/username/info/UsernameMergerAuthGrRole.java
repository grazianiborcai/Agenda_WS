package br.com.gda.security.username.info;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMerger_;

final class UsernameMergerAuthGrRole extends InfoMerger_<UsernameInfo, AuthGrRoleInfo, UsernameInfo> {
	public UsernameInfo merge(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UsernameVisiMergeAuthGrRole());
	}
	
	
	
	public List<UsernameInfo> merge(List<AuthGrRoleInfo> sourceOnes, List<UsernameInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UsernameVisiMergeAuthGrRole());
	}
}
