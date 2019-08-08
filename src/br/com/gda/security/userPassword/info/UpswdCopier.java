package br.com.gda.security.userPassword.info;


import java.util.List;

import br.com.gda.info.InfoCopier;
import br.com.gda.security.user.info.UserInfo;

public final class UpswdCopier {	
	public static UpswdInfo copyFromUser(UserInfo source) {
		InfoCopier<UpswdInfo, UserInfo> copier = new UpswdCopyUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UpswdInfo> copyFromUser(List<UserInfo> sources) {
		InfoCopier<UpswdInfo, UserInfo> copier = new UpswdCopyUser();
		return copier.makeCopy(sources);
	}
}
