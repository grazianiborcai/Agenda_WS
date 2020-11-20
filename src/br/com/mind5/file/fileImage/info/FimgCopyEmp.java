package br.com.mind5.file.fileImage.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class FimgCopyEmp extends InfoCopierTemplate<FimgInfo, EmpInfo> {
	
	public FimgCopyEmp() {
		super();
	}
	
	
	
	@Override protected FimgInfo makeCopyHook(EmpInfo source) {		
		FimgInfo result = new FimgInfo();
		
		result.codOwner = source.codOwner;
		result.codFileImg = source.fimistData.codFileImg;
		result.codEmployee = source.codEmployee;
		result.codLanguage = source.codLanguage;
		result.username = source.username;
		
		return result;
	}
}
