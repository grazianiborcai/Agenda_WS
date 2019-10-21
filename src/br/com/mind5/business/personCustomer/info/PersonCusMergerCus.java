package br.com.mind5.business.personCustomer.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

final class PersonCusMergerCus extends InfoMerger_<PersonCusInfo, CusInfo, PersonCusInfo> {
	public PersonCusInfo merge(CusInfo sourceOne, PersonCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonCusVisitorCus());
	}
	
	
	
	public List<PersonCusInfo> merge(List<CusInfo> sourceOnes, List<PersonCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonCusVisitorCus());
	}
}
