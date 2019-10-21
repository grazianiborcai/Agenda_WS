package br.com.mind5.security.userAuthentication.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoWritterFactory_;
import br.com.mind5.security.user.info.UserInfo;

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
