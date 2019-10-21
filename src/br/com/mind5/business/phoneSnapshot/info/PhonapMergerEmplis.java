package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

public final class PhonapMergerEmplis extends InfoMergerTemplate<PhonapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, EmplisInfo> getVisitorHook() {
		return new PhonapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
