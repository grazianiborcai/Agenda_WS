package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyEmplis extends InfoCopierTemplate<FimistInfo, EmplisInfo> {
	
	public FimistCopyEmplis() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(EmplisInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
