package br.com.gda.security.userList.info;


import java.util.List;

import br.com.gda.business.ownerSnapshot.info.OwnerapInfo;
import br.com.gda.info.InfoCopier;

public final class UselisCopier {
	public static UselisInfo copyFromOwnerap(OwnerapInfo source) {
		InfoCopier<UselisInfo, OwnerapInfo> copier = new UselisCopyOwnerap();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UselisInfo> copyFromOwnerap(List<OwnerapInfo> sources) {
		InfoCopier<UselisInfo, OwnerapInfo> copier = new UselisCopyOwnerap();
		return copier.makeCopy(sources);
	}
}
