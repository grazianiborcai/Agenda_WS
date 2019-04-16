package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerUser extends InfoMerger<CusInfo, UserInfo, CusInfo> {
	public CusInfo merge(UserInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisiMergeUser());
	}
	
	
	
	public List<CusInfo> merge(List<UserInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisiMergeUser());
	}
}
