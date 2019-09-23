package br.com.gda.business.phoneSnapshot.info;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

public final class PhonapMergerEmplis extends InfoMergerTemplate<PhonapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor<PhonapInfo, EmplisInfo> getVisitorHook() {
		return new PhonapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
