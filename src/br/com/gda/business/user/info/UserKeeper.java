package br.com.gda.business.user.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory;

public final class UserKeeper extends InfoWritterFactory<UserInfo> {	
	
	public UserKeeper() {
		super(new UserUniquifier());
	}
	
	
	
	@Override protected boolean isKeeperHook() {
		return super.ENABLED;
	}
	
	
	
	static public UserInfo keep(UserInfo sourceOne, UserInfo sourceTwo) {
		return new UserKeeperUser().keep(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UserInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof UserInfo		)
			return new UserKeeperUser().keep((List<UserInfo>) sourceOnes, (List<UserInfo>) sourceTwos);
		
		
		return null;
	}
}
