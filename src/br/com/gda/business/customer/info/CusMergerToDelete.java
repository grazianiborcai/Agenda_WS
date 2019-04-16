package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

final class CusMergerToDelete extends InfoMerger<CusInfo, CusInfo, CusInfo> {
	public CusInfo merge(CusInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiMergeToDelete());
	}
	
	
	
	public List<CusInfo> merge(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiMergeToDelete());
	}
}
