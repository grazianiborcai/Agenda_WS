package br.com.gda.business.company.info;


import java.util.List;

import br.com.gda.business.owner.info.OwnerInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.info.InfoCopier;

public final class CompCopier {
	public static CompInfo copyFromOwner(OwnerInfo source) {
		InfoCopier<CompInfo, OwnerInfo> copier = new CompCopyOwner();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CompInfo> copyFromOwner(List<OwnerInfo> sources) {
		InfoCopier<CompInfo, OwnerInfo> copier = new CompCopyOwner();
		return copier.makeCopy(sources);
	}
	
	
	
	public static CompInfo copyFromStore(StoreInfo source) {
		InfoCopier<CompInfo, StoreInfo> copier = new CompCopyStore();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<CompInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopier<CompInfo, StoreInfo> copier = new CompCopyStore();
		return copier.makeCopy(sources);
	}
}
