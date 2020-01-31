package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatsnapMergerMatUnit extends InfoMergerTemplate_<MatsnapInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor_<MatsnapInfo, MatUnitInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
