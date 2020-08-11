package br.com.mind5.security.userPasswordSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.jwtToken.info.JwtokenInfo;

public final class UpswdarchCopier {	
	public static UpswdarchInfo copyFromJwtoken(JwtokenInfo source) {
		InfoCopier<UpswdarchInfo, JwtokenInfo> copier = new UpswdarchCopyJwtoken();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UpswdarchInfo> copyFromJwtoken(List<JwtokenInfo> sources) {
		InfoCopier<UpswdarchInfo, JwtokenInfo> copier = new UpswdarchCopyJwtoken();
		return copier.makeCopy(sources);
	}
}
