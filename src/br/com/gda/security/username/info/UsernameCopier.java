package br.com.gda.security.username.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.info.InfoCopier;

public final class UsernameCopier {
	public static UsernameInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<UsernameInfo, OwnerInfo> copier = new UsernameCopyOwner();
		return copier.makeCopy(sources);
	}
}
