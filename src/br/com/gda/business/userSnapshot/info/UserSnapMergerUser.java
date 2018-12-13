package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class UserSnapMergerUser extends InfoMerger<UserSnapInfo, UserInfo, UserSnapInfo> {
	public UserSnapInfo merge(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorUser());
	}
	
	
	
	public List<UserSnapInfo> merge(List<UserInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorUser());
	}
}
