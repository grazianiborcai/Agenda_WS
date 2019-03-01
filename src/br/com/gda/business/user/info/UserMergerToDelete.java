package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class UserMergerToDelete extends InfoMerger<UserInfo, UserInfo, UserInfo> {
	public UserInfo merge(UserInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergeToDelete());
	}
	
	
	
	public List<UserInfo> merge(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergeToDelete());
	}
}
