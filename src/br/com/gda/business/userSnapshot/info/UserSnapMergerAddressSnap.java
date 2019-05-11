package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddressSnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerAddressSnap extends InfoMerger_<UserSnapInfo, AddressSnapInfo, UserSnapInfo> {
	public UserSnapInfo merge(AddressSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorAddressSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<AddressSnapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorAddressSnap());
	}
}
