package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.personCustomer.info.PersonCusInfo;
import br.com.gda.info.InfoMerger;

final class UserMergerPersonCus extends InfoMerger<UserInfo, PersonCusInfo, UserInfo> {
	public UserInfo merge(PersonCusInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisitorPersonCus());
	}
	
	
	
	public List<UserInfo> merge(List<PersonCusInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisitorPersonCus());
	}
}
