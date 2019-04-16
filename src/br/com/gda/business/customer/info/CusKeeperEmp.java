package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.info.InfoKeeper;

final class CusKeeperEmp extends InfoKeeper<CusInfo, CusInfo> {
	public CusInfo keep(CusInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiKeepEmp());
	}
	
	
	
	public List<CusInfo> keep(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiKeepEmp());
	}
}
