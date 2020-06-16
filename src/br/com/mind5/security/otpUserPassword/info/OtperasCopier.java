package br.com.mind5.security.otpUserPassword.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.userPassword.info.UpswdInfo;

public final class OtperasCopier {	
	public static OtperasInfo copyFromUser(UpswdInfo source) {
		InfoCopier<OtperasInfo, UpswdInfo> copier = new OtperasCopyUpswd();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<OtperasInfo> copyFromUser(List<UpswdInfo> sources) {
		InfoCopier<OtperasInfo, UpswdInfo> copier = new OtperasCopyUpswd();
		return copier.makeCopy(sources);
	}
}
