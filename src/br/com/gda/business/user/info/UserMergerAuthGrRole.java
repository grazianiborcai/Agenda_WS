package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoMerger_;

final class UserMergerAuthGrRole extends InfoMerger_<UserInfo, AuthGrRoleInfo, UserInfo> {
	public UserInfo merge(AuthGrRoleInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergeAuthGrRole());
	}
	
	
	
	public List<UserInfo> merge(List<AuthGrRoleInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergeAuthGrRole());
	}
}
