package br.com.mind5.business.personUser_.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.user.info.UserInfo;

final class PersonUserMergerUser extends InfoMerger_<PersonUserInfo, UserInfo, PersonUserInfo> {
	public PersonUserInfo merge(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonUserVisiMergeUser());
	}
	
	
	
	public List<PersonUserInfo> merge(List<UserInfo> sourceOnes, List<PersonUserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonUserVisiMergeUser());
	}
}
