package br.com.gda.business.person.info;

import java.util.List;

import br.com.gda.business.masterData.info.GenderInfo;
import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoWritterFactory;
import br.com.gda.security.username.info.UsernameInfo;

public final class PersonMerger extends InfoWritterFactory<PersonInfo> {	
	
	public PersonMerger() {
		super();
	}
	
	
	
	static public PersonInfo merge(GenderInfo sourceOne, PersonInfo sourceTwo) {
		return new PersonMergerGender().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PersonInfo merge(PersonInfo sourceOne, PersonInfo sourceTwo) {
		return new PersonMergerToDelete().merge(sourceOne, sourceTwo);
	}
	
	
	
	static public PersonInfo merge(UsernameInfo sourceOne, PersonInfo sourceTwo) {
		return new PersonMergerUsername().merge(sourceOne, sourceTwo);
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Override protected List<PersonInfo> writeHook(List<?> sourceOnes, List<?> sourceTwos) {	
		if (sourceOnes.get(0) instanceof GenderInfo 	&&
			sourceTwos.get(0) instanceof PersonInfo		)
			return new PersonMergerGender().merge((List<GenderInfo>) sourceOnes, (List<PersonInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof PersonInfo 	&&
			sourceTwos.get(0) instanceof PersonInfo		)
			return new PersonMergerToDelete().merge((List<PersonInfo>) sourceOnes, (List<PersonInfo>) sourceTwos);
		
		
		if (sourceOnes.get(0) instanceof UsernameInfo 	&&
			sourceTwos.get(0) instanceof PersonInfo		)
			return new PersonMergerUsername().merge((List<UsernameInfo>) sourceOnes, (List<PersonInfo>) sourceTwos);
		
		
		return null;
	}
}
