package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger_;

final class UpswdMergerUser extends InfoMerger_<UpswdInfo, UserInfo, UpswdInfo> {
	public UpswdInfo merge(UserInfo sourceOne, UpswdInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UpswdVisiMergeUser());
	}
	
	
	
	public List<UpswdInfo> merge(List<UserInfo> sourceOnes, List<UpswdInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UpswdVisiMergeUser());
	}
}
