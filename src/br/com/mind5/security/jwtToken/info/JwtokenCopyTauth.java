package br.com.mind5.security.jwtToken.info;

import br.com.mind5.info.InfoCopierTemplate;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

final class JwtokenCopyTauth extends InfoCopierTemplate<JwtokenInfo, TauthInfo>{
	
	public JwtokenCopyTauth() {
		super();
	}
	
	
	
	@Override protected JwtokenInfo makeCopyHook(TauthInfo source) {
		JwtokenInfo result = new JwtokenInfo();
		result.tokenToVerify = source.tokenToVerify;		
		return result;
	}
}
