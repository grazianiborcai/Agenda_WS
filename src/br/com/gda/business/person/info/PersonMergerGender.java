package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoMerger_;

final class PersonMergerGender extends InfoMerger_<PersonInfo, GenderInfo, PersonInfo> {
	public PersonInfo merge(GenderInfo sourceOne, PersonInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonVisiMergeGender());
	}
	
	
	
	public List<PersonInfo> merge(List<GenderInfo> sourceOnes, List<PersonInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonVisiMergeGender());
	}
}
