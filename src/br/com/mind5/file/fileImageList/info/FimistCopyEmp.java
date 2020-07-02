package br.com.mind5.file.fileImageList.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimistCopyEmp extends InfoCopierTemplate<FimistInfo, EmpInfo> {
	
	public FimistCopyEmp() {
		super();
	}
	
	
	
	@Override protected FimistInfo makeCopyHook(EmpInfo source) {
		FimistInfo result = new FimistInfo();
		
		result.codOwner = source.codOwner;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
