package br.com.gda.security.userAuthentication.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class UauthMergerUser extends InfoMerger<UauthInfo, UserInfo, UauthInfo> {
	public UauthInfo merge(UserInfo sourceOne, UauthInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UauthVisiMergeUser());
	}
	
	
	
	public List<UauthInfo> merge(List<UserInfo> sourceOnes, List<UauthInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UauthVisiMergeUser());
	}
}
