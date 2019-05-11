package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PersonSnapMergerPerson extends InfoMerger_<PersonSnapInfo, PersonInfo, PersonSnapInfo> {
	public PersonSnapInfo merge(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonSnapVisitorPerson());
	}
	
	
	
	public List<PersonSnapInfo> merge(List<PersonInfo> sourceOnes, List<PersonSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonSnapVisitorPerson());
	}
}
