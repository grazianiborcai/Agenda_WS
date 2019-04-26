package br.com.gda.business.personSnapshot.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.business.snapshot.info.SnapInfo;
import br.com.gda.info.InfoWritterFactory_;

public final class PersonSnapMerger extends InfoWritterFactory_<PersonSnapInfo> {	
	
	public PersonSnapMerger() {
		super();
	}
	
	
	
	static public PersonSnapInfo merge(GenderInfo sourceOne, PersonSnapInfo sourceTwo) {
		return new PersonSnapMergerGender().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PersonSnapInfo merge(PersonInfo sourceOne, PersonSnapInfo sourceTwo) {
		return new PersonSnapMergerPerson().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PersonSnapInfo merge(SnapInfo sourceOne, PersonSnapInfo sourceTwo) {
		return new PersonSnapMergerSnap().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonSnapInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof GenderInfo 	&&
			sourceTwos.get(0) instanceof PersonSnapInfo		)
			return new PersonSnapMergerGender().merge((List<GenderInfo>) sourceOnes, (List<PersonSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof PersonSnapInfo		)
			return new PersonSnapMergerPerson().merge((List<PersonInfo>) sourceOnes, (List<PersonSnapInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof SnapInfo 		&&
			sourceTwos.get(0) instanceof PersonSnapInfo		)
			return new PersonSnapMergerSnap().merge((List<SnapInfo>) sourceOnes, (List<PersonSnapInfo>) sourceTwos);
		
		
		return null;
	}
}
