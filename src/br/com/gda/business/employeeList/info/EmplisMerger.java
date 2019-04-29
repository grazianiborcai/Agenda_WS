package br.com.gda.business.employeeList.info;

import java.util.List;

import br.com.gda.business.person.info.PersonInfo;
import br.com.gda.info.InfoMerger;

public final class EmplisMerger {
	public static EmplisInfo mergeWithPerson(PersonInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, PersonInfo> merger = new EmplisMergerPerson();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithPerson(List<PersonInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, PersonInfo> merger = new EmplisMergerPerson();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
