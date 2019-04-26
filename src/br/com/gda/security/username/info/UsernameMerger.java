package br.com.gda.security.username.info;

import java.util.List;

import br.com.gda.business.masterData.info.AuthGrRoleInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class UsernameMerger extends InfoWritterFactory_<UsernameInfo> {	
	
	public UsernameMerger() {
		super(new UsernameUniquifier());
	}
	
	
	
	static public UsernameInfo merge(AuthGrRoleInfo sourceOne, UsernameInfo sourceTwo) {
		return new UsernameMergerAuthGrRole().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UsernameInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		
		if (sourceOnes.get(0) instanceof AuthGrRoleInfo 	&&
			sourceTwos.get(0) instanceof UsernameInfo		)
			return new UsernameMergerAuthGrRole().merge((List<AuthGrRoleInfo>) sourceOnes, (List<UsernameInfo>) sourceTwos);
		
		return null;
	}
}
