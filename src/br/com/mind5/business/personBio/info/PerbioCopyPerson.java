package br.com.mind5.business.personBio.info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopierOneToManyTemplate;

final class PerbioCopyPerson extends InfoCopierOneToManyTemplate<PerbioInfo, PersonInfo> {
	
	public PerbioCopyPerson() {
		super();
	}
	
	
	
	@Override protected List<PerbioInfo> makeCopyHook(PersonInfo source) {
		if (shouldCopy(source) == false)
			return Collections.emptyList();		
		
		List<PerbioInfo> results = new ArrayList<>();
		
		for (PerbioInfo eachRecod : source.perbios) {
			results.add(eachRecod);
		}
		
		
		return results;
	}
	
	
	
	private boolean shouldCopy(PersonInfo source) {
		if (source.perbios == null)
			return false;
		
		if (source.perbios.isEmpty())
			return false;
		
		return true;
	}
}
