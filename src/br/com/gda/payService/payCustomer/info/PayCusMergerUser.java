package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.user.info.UserInfo;
import br.com.gda.info.InfoMerger;

final class PayCusMergerUser extends InfoMerger<PayCusInfo, UserInfo, PayCusInfo> {
	public PayCusInfo merge(UserInfo sourceOne, PayCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayCusVisitorUser());
	}
	
	
	
	public List<PayCusInfo> merge(List<UserInfo> sourceOnes, List<PayCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayCusVisitorUser());
	}
}
