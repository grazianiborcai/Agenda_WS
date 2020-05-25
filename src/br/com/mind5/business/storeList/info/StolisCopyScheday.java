package br.com.mind5.business.storeList.info;


import br.com.mind5.business.scheduleDay.info.SchedayInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolisCopyScheday extends InfoCopierTemplate<StolisInfo, SchedayInfo> {
	
	public StolisCopyScheday() {
		super();
	}
	
	
	
	@Override protected StolisInfo makeCopyHook(SchedayInfo source) {
		StolisInfo result = new StolisInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;			
	}
}
