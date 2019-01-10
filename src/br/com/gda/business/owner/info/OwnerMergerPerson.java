package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerPerson extends InfoMerger<OwnerInfo, PersonInfo, OwnerInfo> {
	public OwnerInfo merge(PersonInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisitorPerson());
	}
	
	
	
	public List<OwnerInfo> merge(List<PersonInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisitorPerson());
	}
}
