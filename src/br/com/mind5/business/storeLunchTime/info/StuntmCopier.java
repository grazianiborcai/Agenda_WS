package br.com.mind5.business.storeLunchTime.info;

import java.util.List;

import br.com.mind5.business.store.info.StoreInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class StuntmCopier {
	public static List<StuntmInfo> copyFromStore(List<StoreInfo> sources) {
		InfoCopierOneToMany<StuntmInfo, StoreInfo> copier = new StuntmCopyStore();
		return copier.makeCopy(sources);
	}	
}
