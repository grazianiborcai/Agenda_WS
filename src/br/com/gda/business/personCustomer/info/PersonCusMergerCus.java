package br.com.gda.business.personCustomer.info;

import java.util.List;

import br.com.gda.business.customer.info.CusInfo;
import br.com.gda.info.InfoMerger;

final class PersonCusMergerCus extends InfoMerger<PersonCusInfo, CusInfo, PersonCusInfo> {
	public PersonCusInfo merge(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonCusVisitorCus());
	}
	
	
	
	public List<PersonCusInfo> merge(List<CusInfo> sourceOnes, List<PersonCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonCusVisitorCus());
	}
}
