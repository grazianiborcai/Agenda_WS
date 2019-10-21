package br.com.mind5.business.materialSnapshot.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatsnapMergerMatUnit extends InfoMergerTemplate<MatsnapInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor<MatsnapInfo, MatUnitInfo> getVisitorHook() {
		return new MatsnapVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatsnapInfo> getUniquifierHook() {
		return new MatsnapUniquifier();
	}
}
