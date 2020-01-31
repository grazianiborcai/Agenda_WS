package br.com.mind5.business.materialList.info;

import br.com.mind5.business.masterData.info.MatUnitInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class MatlisMergerMatUnit extends InfoMergerTemplate_<MatlisInfo, MatUnitInfo> {

	@Override protected InfoMergerVisitor_<MatlisInfo, MatUnitInfo> getVisitorHook() {
		return new MatlisVisiMergeMatUnit();
	}
	
	
	
	@Override protected InfoUniquifier<MatlisInfo> getUniquifierHook() {
		return new MatlisUniquifier();
	}
}
