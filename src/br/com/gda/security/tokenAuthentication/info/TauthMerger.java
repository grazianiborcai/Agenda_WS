package br.com.gda.security.tokenAuthentication.info;

import java.util.List;

import br.com.gda.info.InfoWritterFactory_;
import br.com.gda.security.jwtToken.info.JwtokenInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class TauthMerger extends InfoWritterFactory_<TauthInfo> {	
	
	public TauthMerger() {
		super(new TauthUniquifier());
	}
	
	
	
	static public TauthInfo merge(UsernameInfo sourceOne, TauthInfo sourceTwo) {
		return new TauthMergerUsername().merge(sourceOne, sourceTwo);
	}	
	
	
	
	static public TauthInfo merge(JwtokenInfo sourceOne, TauthInfo sourceTwo) {
		return new TauthMergerJwtoken().merge(sourceOne, sourceTwo);
	}	
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<TauthInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof TauthInfo		)
			return new TauthMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<TauthInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof JwtokenInfo 	&&
			sourceTwos.get(0) instanceof TauthInfo		)
			return new TauthMergerJwtoken().merge((List<JwtokenInfo>) sourceOnes, (List<TauthInfo>) sourceTwos);
		
		return null;
	}
}
