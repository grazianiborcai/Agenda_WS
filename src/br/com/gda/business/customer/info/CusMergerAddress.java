package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.address.info.AddressInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerAddress extends InfoMerger<CusInfo, AddressInfo, CusInfo> {
	public CusInfo merge(AddressInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiMergeAddress());
	}
	
	
	
	public List<CusInfo> merge(List<AddressInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiMergeAddress());
	}
}
