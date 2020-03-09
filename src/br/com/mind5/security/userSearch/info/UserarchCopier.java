package br.com.mind5.security.userSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.user.info.UserInfo;

public final class UserarchCopier {
	public static UserarchInfo copyFromUser(UserInfo source) {
		InfoCopier<UserarchInfo, UserInfo> copier = new UserarchCopyUser();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserarchInfo> copyFromUser(List<UserInfo> sources) {
		InfoCopier<UserarchInfo, UserInfo> copier = new UserarchCopyUser();
		return copier.makeCopy(sources);
	}
}
