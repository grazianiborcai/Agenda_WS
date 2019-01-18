package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger;

final class PayCusMergerPerson extends InfoMerger<PayCusInfo, PersonInfo, PayCusInfo> {
	public PayCusInfo merge(PersonInfo sourceOne, PayCusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PayCusVisiPerson());
	}
	
	
	
	public List<PayCusInfo> merge(List<PersonInfo> sourceOnes, List<PayCusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PayCusVisiPerson());
	}
}
