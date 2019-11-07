package br.com.mind5.business.employeePositionSearch.info;

import br.com.mind5.business.employeePosition.info.EmposInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmposarchCopyEmpos extends InfoCopierTemplate<EmposarchInfo, EmposInfo> {
	
	public EmposarchCopyEmpos() {
		super();
	}
	
	
	
	@Override protected EmposarchInfo makeCopyHook(EmposInfo source) {
		EmposarchInfo result = new EmposarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codEmployee = source.codEmployee;
		result.username = source.username;
		result.codLanguage = source.codLanguage;		
		
		return result;
	}
}
