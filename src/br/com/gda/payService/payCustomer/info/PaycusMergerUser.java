package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PaycusMergerUser extends InfoMerger_<PaycusInfo, UserInfo, PaycusInfo> {
	public PaycusInfo merge(UserInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiUser());
	}
	
	
	
	public List<PaycusInfo> merge(List<UserInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiUser());
	}
}
