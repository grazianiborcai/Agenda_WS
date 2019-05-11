package br.com.gda.business.userSnapshot.info;

import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class UserSnapMergerPersonCus extends InfoMerger_<UserSnapInfo, PersonCusInfo, UserSnapInfo> {
	public UserSnapInfo merge(PersonCusInfo sourceOne, UserSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserSnapVisitorPersonCus());
	}
	
	
	
	public List<UserSnapInfo> merge(List<PersonCusInfo> sourceOnes, List<UserSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserSnapVisitorPersonCus());
	}
}
