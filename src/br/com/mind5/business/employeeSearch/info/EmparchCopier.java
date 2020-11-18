package br.com.mind5.business.employeeSearch.info;


import java.util.List;

import br.com.mind5.info.InfoCopier;
import br.com.mind5.security.user.info.UserInfo;

public final class EmparchCopier {
	public static EmparchInfo copyFromUserEmail(UserInfo source) {
		InfoCopier<EmparchInfo, UserInfo> copier = new EmparchCopyUserEmail();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<EmparchInfo> copyFromUserEmail(List<UserInfo> sources) {
		InfoCopier<EmparchInfo, UserInfo> copier = new EmparchCopyUserEmail();
		return copier.makeCopy(sources);
	}
}
