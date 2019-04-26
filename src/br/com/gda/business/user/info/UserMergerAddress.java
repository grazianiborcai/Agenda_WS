package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger_;

final class UserMergerAddress extends InfoMerger_<UserInfo, AddressInfo, UserInfo> {
	public UserInfo merge(AddressInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergeAddress());
	}
	
	
	
	public List<UserInfo> merge(List<AddressInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergeAddress());
	}
}
