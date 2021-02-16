package br.com.mind5.business.employeeRestricted.info;

import br.com.mind5.business.scheduleLine.info.SchedineInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class EmplresCopySchedine extends InfoCopierTemplate<EmplresInfo, SchedineInfo> {
	
	public EmplresCopySchedine() {
		super();
	}
	
	
	
	@Override protected EmplresInfo makeCopyHook(SchedineInfo source) {
		EmplresInfo result = new EmplresInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
