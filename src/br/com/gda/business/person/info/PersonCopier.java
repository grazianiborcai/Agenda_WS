package br.com.gda.business.person.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopier;

public final class PersonCopier {
	public static PersonInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<PersonInfo, OwnerInfo> copier = new PersonCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<PersonInfo, OwnerInfo> copier = new PersonCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PersonInfo copyFromStore(StoreInfo source) {
		InfoCopier<PersonInfo, StoreInfo> copier = new PersonCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PersonInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<PersonInfo, StoreInfo> copier = new PersonCopyStore();
		return copier.makeCopy(sources);
	}
}
