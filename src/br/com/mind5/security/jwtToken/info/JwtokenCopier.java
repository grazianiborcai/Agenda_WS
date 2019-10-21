package br.com.mind5.security.jwtToken.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.tokenAuthentication.info.TauthInfo;

public final class JwtokenCopier {
	public static JwtokenInfo copyFromTauth(TauthInfo source) {
		InfoCopier<JwtokenInfo, TauthInfo> copier = new JwtokenCopyTauth();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<JwtokenInfo> copyFromTauth(List<TauthInfo> sources) {
		InfoCopier<JwtokenInfo, TauthInfo> copier = new JwtokenCopyTauth();
		return copier.makeCopy(sources);
	}
}
