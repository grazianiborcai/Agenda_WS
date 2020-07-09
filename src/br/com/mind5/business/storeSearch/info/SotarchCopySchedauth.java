package br.com.mind5.business.storeSearch.info;

import br.com.mind5.authorization.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class SotarchCopySchedauth extends InfoCopierTemplate<SotarchInfo, SchedauthInfo>{
	
	public SotarchCopySchedauth() {
		super();
	}
	
	
	
	@Override protected SotarchInfo makeCopyHook(SchedauthInfo source) {
		SotarchInfo result = new SotarchInfo();
		
		result.codOwner = source.codOwner;
		result.codUser = source.codUser;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
