package br.com.mind5.business.storeWorkTimeSearch.info;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StowotarchCopyEmpwotm extends InfoCopierTemplate<StowotarchInfo, EmpwotmInfo> {
	
	public StowotarchCopyEmpwotm() {
		super();
	}
	
	
	
	@Override protected StowotarchInfo makeCopyHook(EmpwotmInfo source) {
		StowotarchInfo result = new StowotarchInfo();
		
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		
		return result;
	}
}
