package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger;

final class UserMergerAddress extends InfoMerger<UserInfo, AddressInfo, UserInfo> {
	public UserInfo merge(AddressInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisitorAddress());
	}
	
	
	
	public List<UserInfo> merge(List<AddressInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisitorAddress());
	}
}
