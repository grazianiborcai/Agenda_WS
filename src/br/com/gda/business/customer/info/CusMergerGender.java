package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerGender extends InfoMerger<CusInfo, GenderInfo, CusInfo> {
	public CusInfo merge(GenderInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisitorGender());
	}
	
	
	
	public List<CusInfo> merge(List<GenderInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisitorGender());
	}
}
