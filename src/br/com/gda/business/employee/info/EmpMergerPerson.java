package br.com.gda.business.employee.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger_;

final class EmpMergerPerson extends InfoMerger_<EmpInfo, PersonInfo, EmpInfo> {
	public EmpInfo merge(PersonInfo sourceOne, EmpInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmpVisiMergePerson());
	}
	
	
	
	public List<EmpInfo> merge(List<PersonInfo> sourceOnes, List<EmpInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmpVisiMergePerson());
	}
}
