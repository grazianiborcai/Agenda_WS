package br.com.gda.business.employeePosition.info;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class EmposMergerPosition extends InfoMergerTemplate<EmposInfo, PositionInfo> {

	@Override protected InfoMergerVisitor<EmposInfo, PositionInfo> getVisitorHook() {
		return new EmposVisiMergePosition();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
