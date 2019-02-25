package br.com.gda.security.jwtToken.info;

import br.com.gda.info.InfoCopierTemplate;
import br.com.gda.security.tokenAuthentication.info.TauthInfo;

final class JwtokenCopyTauth extends InfoCopierTemplate<JwtokenInfo, TauthInfo>{
	
	public JwtokenCopyTauth() {
		super();
	}
	
	
	
	@Override protected JwtokenInfo makeCopyHook(TauthInfo source) {
		JwtokenInfo result = new JwtokenInfo();
		result.tokenEncoded = source.token;		
		return result;
	}
}
