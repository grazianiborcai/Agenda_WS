package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PersonSnapMerger extends InfoWritterFactory<PersonSnapInfo> {	
	
	public PersonSnapMerger() {
		super();
	}
	
	
	
	static public PersonSnapInfo merge(GenderInfo sourceOne, PersonSnapInfo sourceTwo) {
		return new PersonSnapMergerGender().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof GenderInfo 	&&
			sourceTwos.get(0) instanceof PersonSnapInfo		)
			return new PersonSnapMergerGender().merge((List<GenderInfo>) sourceOnes, (List<PersonSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
