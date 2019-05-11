package br.com.gda.business.personUser_.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PersonUserMergerUser extends InfoMerger_<PersonUserInfo, UserInfo, PersonUserInfo> {
	public PersonUserInfo merge(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonUserVisitorUser());
	}
	
	
	
	public List<PersonUserInfo> merge(List<UserInfo> sourceOnes, List<PersonUserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonUserVisitorUser());
	}
}
