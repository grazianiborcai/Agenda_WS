package br.com.mind5.business.employeeSnapshot.info;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpnapMergerPersolis extends InfoMergerTemplate_<EmpnapInfo, PersolisInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, PersolisInfo> getVisitorHook() {
		return new EmpnapVisiMergePersolis();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
