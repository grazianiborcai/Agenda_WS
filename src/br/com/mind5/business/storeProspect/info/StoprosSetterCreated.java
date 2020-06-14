package br.com.mind5.business.storeProspect.info;

import br.com.mind5.info.InfoSetterTemplate;
import br.com.mind5.masterData.common.Prostus;

public final class StoprosSetterCreated extends InfoSetterTemplate<StoprosInfo> {
	
	@Override protected StoprosInfo setAttrHook(StoprosInfo recordInfo) {
		recordInfo.codProspectStatus = Prostus.CREATED.getCodProspectStatus();		
		return recordInfo;
	}
}
