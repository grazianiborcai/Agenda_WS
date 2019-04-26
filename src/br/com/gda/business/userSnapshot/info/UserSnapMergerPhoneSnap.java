package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhoneSnapInfo;
import br.com.gda.info.InfoMerger_;

final class UserSnapMergerPhoneSnap extends InfoMerger_<UserSnapInfo, PhoneSnapInfo, UserSnapInfo> {
	public UserSnapInfo merge(PhoneSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorPhoneSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<PhoneSnapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorPhoneSnap());
	}
}
