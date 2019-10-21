package br.com.mind5.business.company.info;


import java.util.List;

import br.com.mind5.business.owner.info.OwnerInfo;
import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopier;

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
