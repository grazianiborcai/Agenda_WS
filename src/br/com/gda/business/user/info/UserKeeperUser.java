package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.info.InfoKeeper;

final class UserKeeperUser extends InfoKeeper<UserInfo, UserInfo> {
	public UserInfo keep(UserInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiKeepUser());
	}
	
	
	
	public List<UserInfo> keep(List<UserInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiKeepUser());
	}
}
