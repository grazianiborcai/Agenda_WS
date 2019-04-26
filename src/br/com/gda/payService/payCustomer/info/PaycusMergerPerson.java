package br.com.gda.payService.payCustomer.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger_;

final class PaycusMergerPerson extends InfoMerger_<PaycusInfo, PersonInfo, PaycusInfo> {
	public PaycusInfo merge(PersonInfo sourceOne, PaycusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PaycusVisiPerson());
	}
	
	
	
	public List<PaycusInfo> merge(List<PersonInfo> sourceOnes, List<PaycusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PaycusVisiPerson());
	}
}
