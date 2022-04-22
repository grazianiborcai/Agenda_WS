package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class StowotmCopier {
	public static List<StowotmInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopierOneToMany<StowotmInfo, StoreInfo> copier = new StowotmCopyStore();
		return copier.makeCopy(sources);
	}	
}
