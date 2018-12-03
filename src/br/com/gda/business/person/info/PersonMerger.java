package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoWritterFactory;

public final class PersonMerger extends InfoWritterFactory<PersonInfo> {	
	
	public PersonMerger() {
		super();
	}
	
	
	
	static public PersonInfo merge(GenderInfo sourceOne, PersonInfo sourceTwo) {
		return new PersonMergerGender().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof GenderInfo 	&&
			sourceTwos.get(0) instanceof PersonInfo		)
			return new PersonMergerGender().merge((List<GenderInfo>) sourceOnes, (List<PersonInfo>) sourceTwos);
		
		
		return null;
	}
}
