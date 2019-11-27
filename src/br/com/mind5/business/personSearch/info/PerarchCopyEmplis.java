package br.com.mind5.business.personSearch.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PerarchCopyEmplis extends InfoCopierTemplate<PerarchInfo, EmplisInfo>{
	
	public PerarchCopyEmplis() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(EmplisInfo source) {
		PerarchInfo result = PerarchInfo.copyFrom(source.persolisData);
		return result;
	}
}
