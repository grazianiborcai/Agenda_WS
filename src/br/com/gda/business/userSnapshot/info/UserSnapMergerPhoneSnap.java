package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerPhoneSnap extends InfoMerger_<UserSnapInfo, PhonapInfo, UserSnapInfo> {
	public UserSnapInfo merge(PhonapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorPhoneSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<PhonapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorPhoneSnap());
	}
}
