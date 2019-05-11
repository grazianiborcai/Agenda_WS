package br.com.gda.business.materialSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.MatGroupInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class MatSnapMergerMatGroup extends InfoMerger_<MatSnapInfo, MatGroupInfo, MatSnapInfo> {
	public MatSnapInfo merge(MatGroupInfo sourceOne, MatSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new MatSnapVisitorMatGroup());
	}
	
	
	
	public List<MatSnapInfo> merge(List<MatGroupInfo> sourceOnes, List<MatSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new MatSnapVisitorMatGroup());
	}
}
