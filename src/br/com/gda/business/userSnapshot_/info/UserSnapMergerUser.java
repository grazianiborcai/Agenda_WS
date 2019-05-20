package br.com.gda.business.userSnapshot_.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerUser extends InfoMerger_<UserSnapInfo, UserInfo, UserSnapInfo> {
	public UserSnapInfo merge(UserInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorUser());
	}
	
	
	
	public List<UserSnapInfo> merge(List<UserInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorUser());
	}
}
