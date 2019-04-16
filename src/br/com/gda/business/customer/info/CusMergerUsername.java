package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class CusMergerUsername extends InfoMerger<CusInfo, UsernameInfo, CusInfo> {
	public CusInfo merge(UsernameInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiMergeUsername());
	}
	
	
	
	public List<CusInfo> merge(List<UsernameInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiMergeUsername());
	}
}
