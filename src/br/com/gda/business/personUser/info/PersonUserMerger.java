package br.com.gda.business.personUser.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class PersonUserMerger extends InfoWritterFactory_<PersonUserInfo> {	
	
	public PersonUserMerger() {
		super();
	}
	
	
	
	static public PersonUserInfo merge(UserInfo sourceOne, PersonUserInfo sourceTwo) {
		return new PersonUserMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonUserInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof PersonUserInfo		)
			return new PersonUserMergerUser().merge((List<UserInfo>) sourceOnes, (List<PersonUserInfo>) sourceTwos);
		
		return null;
	}
}
