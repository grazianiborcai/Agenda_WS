package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class PersonMergerToDelete extends InfoMerger_<PersonInfo, PersonInfo, PersonInfo> {
	public PersonInfo merge(PersonInfo sourceOne, PersonInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonVisiMergeToDelete());
	}
	
	
	
	public List<PersonInfo> merge(List<PersonInfo> sourceOnes, List<PersonInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonVisiMergeToDelete());
	}
}
