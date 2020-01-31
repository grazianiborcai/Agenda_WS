package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmplisMergerPersores extends InfoMergerTemplate_<EmplisInfo, PersoresInfo> {

	@Override protected InfoMergerVisitor_<EmplisInfo, PersoresInfo> getVisitorHook() {
		return new EmplisVisiMergePersores();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
