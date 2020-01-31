package br.com.mind5.business.employeeSnapshot.info;


import br.com.mind5.business.phoneSnapshot.info.PhonapInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmpnapMergerPhonap extends InfoMergerTemplate_<EmpnapInfo, PhonapInfo> {

	@Override protected InfoMergerVisitor_<EmpnapInfo, PhonapInfo> getVisitorHook() {
		return new EmpnapVisiMergePhonap();
	}
	
	
	
	@Override protected InfoUniquifier<EmpnapInfo> getUniquifierHook() {
		return new EmpnapUniquifier();
	}
}
