package br.com.mind5.business.employeePosition.info;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class EmposMergerPosition extends InfoMergerTemplate<EmposInfo, PositionInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, PositionInfo> getVisitorHook() {
		return new EmposVisiMergePosition();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
