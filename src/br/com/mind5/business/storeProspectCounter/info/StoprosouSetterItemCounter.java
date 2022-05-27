package br.com.mind5.business.storeProspectCounter.info;

import br.com.mind5.info.InfoSetterTemplate;

public final class StoprosouSetterItemCounter extends InfoSetterTemplate<StoprosouInfo> {
	
	@Override protected StoprosouInfo setAttrHook(StoprosouInfo recordInfo) {
		if (recordInfo.stoproses == null)
			return setZeroItem(recordInfo);
		
		if (recordInfo.stoproses.isEmpty())
			return setZeroItem(recordInfo);
		
		return setTotItem(recordInfo);
	}
	
	
	
	private StoprosouInfo setZeroItem(StoprosouInfo recordInfo) {
		recordInfo.itemCounter = 0;
		return recordInfo;
	}
	
	
	
	private StoprosouInfo setTotItem(StoprosouInfo recordInfo) {
		recordInfo.itemCounter = recordInfo.stoproses.size();	
		return recordInfo;
	}
}
