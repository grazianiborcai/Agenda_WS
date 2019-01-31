package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoMerger;

final class EmposMergerPosition extends InfoMerger<EmposInfo, PositionInfo, EmposInfo> {
	public EmposInfo merge(PositionInfo sourceOne, EmposInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmposVisitorPosition());
	}
	
	
	
	public List<EmposInfo> merge(List<PositionInfo> sourceOnes, List<EmposInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmposVisitorPosition());
	}
}
