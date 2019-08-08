package br.com.gda.business.personUser_.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoWritterFactory_;
import br.com.gda.security.user.info.UserInfo;

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
