package br.com.mind5.business.storeSnapshot.info;

import br.com.mind5.business.storeTextSnapshot.info.StorextsnapInfo;
import br.com.mind5.info.InfoSetterTemplate;

public final class StorapSetterStorextsnapKey extends InfoSetterTemplate<StorapInfo> {
	
	@Override protected StorapInfo setAttrHook(StorapInfo recordInfo) {
		
		for (StorextsnapInfo eachStorextsnap : recordInfo.storextsnapes) {
			eachStorextsnap.codOwner = recordInfo.codOwner;
			eachStorextsnap.codStore = recordInfo.codStore;
			eachStorextsnap.username = recordInfo.username;
			eachStorextsnap.codSnapshot = recordInfo.codSnapshot;
		}
		
		return recordInfo;
	}
}
