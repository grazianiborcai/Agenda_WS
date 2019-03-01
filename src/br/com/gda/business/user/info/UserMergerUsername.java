package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class UserMergerUsername extends InfoMerger<UserInfo, UsernameInfo, UserInfo> {
	public UserInfo merge(UsernameInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergeUsername());
	}
	
	
	
	public List<UserInfo> merge(List<UsernameInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergeUsername());
	}
}
