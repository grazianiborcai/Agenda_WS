package br.com.gda.business.personSearch.info;


import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoCopier;

public final class PerarchCopier {
	public static PerarchInfo copyFromPersonEmail(PersonInfo source) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmail();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromPersonEmail(List<PersonInfo> sources) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmail();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PerarchInfo copyFromPersonCpf(PersonInfo source) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonCpf();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromPersonCpf(List<PersonInfo> sources) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonCpf();
		return copier.makeCopy(sources);
	}
}
