package br.com.gda.security.username.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
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
	
	
	
	public static UsernameInfo copyFromStore(StoreInfo source) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<UsernameInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<UsernameInfo, StoreInfo> copier = new UsernameCopyStore();
		return copier.makeCopy(sources);
	}
}
