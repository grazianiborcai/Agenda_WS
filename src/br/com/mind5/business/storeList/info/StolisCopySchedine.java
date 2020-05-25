package br.com.mind5.business.storeList.info;


import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StolisCopySchedine extends InfoCopierTemplate<StolisInfo, SchedineInfo> {
	
	public StolisCopySchedine() {
		super();
	}
	
	
	
	@Override protected StolisInfo makeCopyHook(SchedineInfo source) {
			StolisInfo result = new StolisInfo();
			
			result.codOwner = source.codOwner;
			result.codStore = source.codStore;
			result.codLanguage = source.codLanguage;
			result.username = source.username;
		
		return result;
	}
}
