package br.com.gda.business.employeeSnapshot.info;


import br.com.gda.business.phoneSnapshot.info.PhonapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitorV2;
import br.com.gda.info.InfoUniquifier;

final class EmpnapMergerPhonap extends InfoMergerTemplate<EmpnapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitorV2<EmpnapInfo, PhonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
