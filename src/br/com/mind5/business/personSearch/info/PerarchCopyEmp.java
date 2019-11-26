package br.com.mind5.business.personSearch.info;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.info.InfoCopierTemplate;

final class PerarchCopyEmp extends InfoCopierTemplate<PerarchInfo, EmpInfo>{
	
	public PerarchCopyEmp() {
		super();
	}
	
	
	
	@Override protected PerarchInfo makeCopyHook(EmpInfo source) {
		PerarchInfo result = PerarchInfo.copyFrom(source.personData);
		return result;
	}
}
