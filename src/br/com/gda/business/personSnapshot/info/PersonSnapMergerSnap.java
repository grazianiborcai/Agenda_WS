package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoMerger;

final class PersonSnapMergerSnap extends InfoMerger<PersonSnapInfo, SnapInfo, PersonSnapInfo> {
	public PersonSnapInfo merge(SnapInfo sourceOne, PersonSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonSnapVisitorSnap());
	}
	
	
	
	public List<PersonSnapInfo> merge(List<SnapInfo> sourceOnes, List<PersonSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonSnapVisitorSnap());
	}
}
