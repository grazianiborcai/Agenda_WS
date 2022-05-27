package br.com.mind5.business.storeProspectSearch.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.prospectStatus.info.Prostus;

public final class StoprarchSetterCreatedKey extends InfoSetterTemplate<StoprarchInfo> {
	
	@Override protected StoprarchInfo setAttrHook(StoprarchInfo recordInfo) {
		StoprarchInfo result = new StoprarchInfo();
		
		result.codOwner = recordInfo.codOwner;
		result.codLanguage = recordInfo.codLanguage;
		result.username = recordInfo.username;
		result.codProspectStatus = Prostus.CREATED.getCodProspectStatus();
		
		return result;
	}
}
