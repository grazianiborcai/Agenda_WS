package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.customerSearch.info.CusarchInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerCusarch extends InfoMerger<CusInfo, CusarchInfo, CusInfo> {
	public CusInfo merge(CusarchInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiMergeCusarch());
	}
	
	
	
	public List<CusInfo> merge(List<CusarchInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiMergeCusarch());
	}
}
