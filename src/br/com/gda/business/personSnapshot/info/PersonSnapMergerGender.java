package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.obsolete.InfoMerger_;

final class PersonSnapMergerGender extends InfoMerger_<PersonSnapInfo, GenderInfo, PersonSnapInfo> {
	public PersonSnapInfo merge(GenderInfo sourceOne, PersonSnapInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new PersonSnapVisitorGender());
	}
	
	
	
	public List<PersonSnapInfo> merge(List<GenderInfo> sourceOnes, List<PersonSnapInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new PersonSnapVisitorGender());
	}
}
