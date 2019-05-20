package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonapInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerPersonSnap extends InfoMerger_<UserSnapInfo, PersonapInfo, UserSnapInfo> {
	public UserSnapInfo merge(PersonapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorPersonSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<PersonapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorPersonSnap());
	}
}
