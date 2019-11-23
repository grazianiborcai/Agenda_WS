package br.com.mind5.business.storeWorkTime.info;

import br.com.mind5.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class StowotmCopyEmpwotm extends InfoCopierTemplate<StowotmInfo, EmpwotmInfo>{
	
	public StowotmCopyEmpwotm() {
		super();
	}
	
	
	
	@Override protected StowotmInfo makeCopyHook(EmpwotmInfo source) {
		StowotmInfo result = new StowotmInfo();
		result.codOwner = source.codOwner;
		result.codStore = source.codStore;
		result.codWeekday = source.codWeekday;
		result.username = source.username;
		result.codLanguage = source.codLanguage;
		return result;
	}
}
