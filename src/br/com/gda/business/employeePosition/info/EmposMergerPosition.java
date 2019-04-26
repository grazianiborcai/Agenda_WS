package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoMerger_;

final class EmposMergerPosition extends InfoMerger_<EmposInfo, PositionInfo, EmposInfo> {
	public EmposInfo merge(PositionInfo sourceOne, EmposInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmposVisiMergePosition());
	}
	
	
	
	public List<EmposInfo> merge(List<PositionInfo> sourceOnes, List<EmposInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmposVisiMergePosition());
	}
}
