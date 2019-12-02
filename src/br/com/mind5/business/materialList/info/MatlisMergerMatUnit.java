package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class MatlisMergerMatUnit extends InfoMergerTemplate<MatlisInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor<MatlisInfo, MatUnitInfo> getVisitorHook() {
		return new MatlisVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
