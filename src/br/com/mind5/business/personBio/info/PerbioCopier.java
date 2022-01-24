package br.com.mind5.business.personBio.info;


import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopierOneToMany;

public final class PerbioCopier {
	public static List<PerbioInfo> copyFromPerson(PersonInfo source) {
		InfoCopierOneToMany<PerbioInfo, PersonInfo> copier = new PerbioCopyPerson();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerbioInfo> copyFromPerson(List<PersonInfo> sources) {
		InfoCopierOneToMany<PerbioInfo, PersonInfo> copier = new PerbioCopyPerson();
		return copier.makeCopy(sources);
	}
}
