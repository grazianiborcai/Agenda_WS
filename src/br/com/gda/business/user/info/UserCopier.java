package br.com.gda.business.user.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoCopier;

public final class UserCopier {
	public static UserInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UserInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<UserInfo, OwnerInfo> copier = new UserCopyOwner();
		return copier.makeCopy(sources);
	}
}
