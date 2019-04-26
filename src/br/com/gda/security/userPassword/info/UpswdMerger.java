package br.com.gda.security.userPassword.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class UpswdMerger extends InfoWritterFactory_<UpswdInfo> {	
	
	public UpswdMerger() {
		super();
	}
	
	
	
	static public UpswdInfo merge(UserInfo sourceOne, UpswdInfo sourceTwo) {
		return new UpswdMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UpswdInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof UpswdInfo		)
			return new UpswdMergerUser().merge((List<UserInfo>) sourceOnes, (List<UpswdInfo>) sourceTwos);
		
		
		return null;
	}
}
