package br.com.mind5.business.personSearch.info;


import java.util.List;

import br.com.mind5.business.employee.info.EmpInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.person.info.PersonInfo;
import br.com.mind5.info.InfoCopier;

public final class PerarchCopier {
	public static PerarchInfo copyFromEmplis(EmplisInfo source) {
		InfoCopier<PerarchInfo, EmplisInfo> copier = new PerarchCopyEmplis();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromEmplis(List<EmplisInfo> sources) {
		InfoCopier<PerarchInfo, EmplisInfo> copier = new PerarchCopyEmplis();
		return copier.makeCopy(sources);
	}
	
	
	
	public static PerarchInfo copyFromEmp(EmpInfo source) {
		InfoCopier<PerarchInfo, EmpInfo> copier = new PerarchCopyEmp();
		return copier.makeCopy(source);
	}
	
	
	
	public static List<PerarchInfo> copyFromEmp(List<EmpInfo> sources) {
		InfoCopier<PerarchInfo, EmpInfo> copier = new PerarchCopyEmp();
		return copier.makeCopy(sources);
	}
	
	
	
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
