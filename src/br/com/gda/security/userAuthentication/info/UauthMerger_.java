package br.com.gda.security.userAuthentication.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class UauthMerger_ extends InfoWritterFactory_<UauthInfo> {	
	
	public UauthMerger_() {
		super();
	}
	
	
	
	static public UauthInfo merge(UserInfo sourceOne, UauthInfo sourceTwo) {
		return new UauthMergerUser().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<UauthInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof UserInfo 	&&
			sourceTwos.get(0) instanceof UauthInfo		)
			return new UauthMergerUser().merge((List<UserInfo>) sourceOnes, (List<UauthInfo>) sourceTwos);
		
		
		return null;
	}
}
