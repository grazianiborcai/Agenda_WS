package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.phone.info.PhoneInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerPhone extends InfoMerger<CusInfo, PhoneInfo, CusInfo> {
	public CusInfo merge(PhoneInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisitorPhone());
	}
	
	
	
	public List<CusInfo> merge(List<PhoneInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisitorPhone());
	}
}
