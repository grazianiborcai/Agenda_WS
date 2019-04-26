package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger_;

final class UserMergerPerson extends InfoMerger_<UserInfo, PersonInfo, UserInfo> {
	public UserInfo merge(PersonInfo sourceOne, UserInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new UserVisiMergePerson());
	}
	
	
	
	public List<UserInfo> merge(List<PersonInfo> sourceOnes, List<UserInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new UserVisiMergePerson());
	}
}
