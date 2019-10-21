package br.com.mind5.business.employeeSnapshot.info;


import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmpnapMergerPhonap extends InfoMergerTemplate<EmpnapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor<EmpnapInfo, PhonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
