package br.com.mind5.business.employeePosition.info;

import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class EmposMergerPosition extends InfoMergerTemplate_<EmposInfo, PositionInfo> {

	@Override protected InfoMergerVisitor_<EmposInfo, PositionInfo> getVisitorHook() {
		return new EmposVisiMergePosition();
	}
	
	
	
	@Override protected InfoUniquifier<EmposInfo> getUniquifierHook() {
		return new EmposUniquifier();
	}
}
