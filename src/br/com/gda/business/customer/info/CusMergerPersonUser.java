package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.personUser.info.PersonUserInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerPersonUser extends InfoMerger<CusInfo, PersonUserInfo, CusInfo> {
	public CusInfo merge(PersonUserInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisitorPersonUser());
	}
	
	
	
	public List<CusInfo> merge(List<PersonUserInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisitorPersonUser());
	}
}
