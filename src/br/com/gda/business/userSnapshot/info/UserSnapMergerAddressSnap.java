package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.addressSnapshot.info.AddresnapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerAddressSnap extends InfoMerger_<UserSnapInfo, AddresnapInfo, UserSnapInfo> {
	public UserSnapInfo merge(AddresnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorAddressSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<AddresnapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorAddressSnap());
	}
}
