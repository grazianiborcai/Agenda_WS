package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger_;

final class UserMergerPhone extends InfoMerger_<UserInfo, PhoneInfo, UserInfo> {
	public UserInfo merge(PhoneInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergePhone());
	}
	
	
	
	public List<UserInfo> merge(List<PhoneInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergePhone());
	}
}
