package br.com.mind5.business.employeeList.info;

import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmplisMergerPersores extends InfoMergerTemplate<EmplisInfo, PersoresInfo> {

	@Override protected InfoMergerVisitor<EmplisInfo, PersoresInfo> getVisitorHook() {
		return new EmplisVisiMergePersores();
	}
	
	
	
	@Override protected InfoUniquifier<EmplisInfo> getUniquifierHook() {
		return new EmplisUniquifier();
	}
}
