package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapMergerPersolis extends InfoMergerTemplate<EmpnapInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, PersolisInfo> getVisitorHook() {
		return new EmpnapVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
