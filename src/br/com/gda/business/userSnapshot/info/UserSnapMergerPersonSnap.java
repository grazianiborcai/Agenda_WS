package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.personSnapshot.info.PersonSnapInfo;
import br.com.gda.info.InfoMerger_;

final class UserSnapMergerPersonSnap extends InfoMerger_<UserSnapInfo, PersonSnapInfo, UserSnapInfo> {
	public UserSnapInfo merge(PersonSnapInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorPersonSnap());
	}
	
	
	
	public List<UserSnapInfo> merge(List<PersonSnapInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorPersonSnap());
	}
}
