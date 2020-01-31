package br.com.mind5.business.phoneSnapshot.info;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

public final class PhonapMergerEmplis extends InfoMergerTemplate_<PhonapInfo, EmplisInfo>{

	@Override protected InfoMergerVisitor_<PhonapInfo, EmplisInfo> getVisitorHook() {
		return new PhonapVisiMergeEmplis();
	}
	
	
	
	@Override protected InfoUniquifier<PhonapInfo> getUniquifierHook() {
		return new PhonapUniquifier();
	}
}
