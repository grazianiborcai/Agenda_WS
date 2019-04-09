package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class EmposMergerToDelete extends InfoMerger<EmposInfo, EmposInfo, EmposInfo> {
	public EmposInfo merge(EmposInfo sourceOne, EmposInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmposVisiMergeToDelete());
	}
	
	
	
	public List<EmposInfo> merge(List<EmposInfo> sourceOnes, List<EmposInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmposVisiMergeToDelete());
	}
}
