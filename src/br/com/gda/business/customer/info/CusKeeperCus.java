package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.info.obsolete.InfoKeeper_;

final class CusKeeperCus extends InfoKeeper_<CusInfo, CusInfo> {
	public CusInfo keep(CusInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiKeepCus());
	}
	
	
	
	public List<CusInfo> keep(List<CusInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiKeepCus());
	}
}
