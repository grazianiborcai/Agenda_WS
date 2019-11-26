package br.com.mind5.business.personSearch.info;


import java.util.List;

import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopier;

public final class PerarchCopier {
	public static PerarchInfo copyFromPersonEmail(PersonInfo source) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmail();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromPersonEmail(List<PersonInfo> sources) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmail();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PerarchInfo copyFromPersonEmailChange(PersonInfo source) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmailChange();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromPersonEmailChange(List<PersonInfo> sources) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonEmailChange();
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
	
	
	
	public static PerarchInfo copyFromPersonCpfChange(PersonInfo source) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonCpfChange();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromPersonCpfChange(List<PersonInfo> sources) {
		InfoCopier<PerarchInfo, PersonInfo> copier = new PerarchCopyPersonCpfChange();
		return copier.makeCopy(sources);
	}	
}
