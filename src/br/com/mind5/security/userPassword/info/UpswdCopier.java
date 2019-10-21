package br.com.mind5.security.userPassword.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.user.info.UserInfo;

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
