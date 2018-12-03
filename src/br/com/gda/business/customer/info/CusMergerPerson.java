package br.com.gda.business.customer.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger;

final class CusMergerPerson extends InfoMerger<CusInfo, PersonInfo, CusInfo> {
	public CusInfo merge(PersonInfo sourceOne, CusInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CusVisitorPerson());
	}
	
	
	
	public List<CusInfo> merge(List<PersonInfo> sourceOnes, List<CusInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CusVisitorPerson());
	}
}
