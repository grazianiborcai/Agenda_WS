package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger_;

final class OwnerMergerPerson extends InfoMerger_<OwnerInfo, PersonInfo, OwnerInfo> {
	public OwnerInfo merge(PersonInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisiMergePerson());
	}
	
	
	
	public List<OwnerInfo> merge(List<PersonInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisiMergePerson());
	}
}
