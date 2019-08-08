package br.com.gda.business.materialSnapshot.info;

import br.com.gda.business.masterData.info.MatUnitInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class MatsnapMergerMatUnit extends InfoMergerTemplate<MatsnapInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatUnitInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
