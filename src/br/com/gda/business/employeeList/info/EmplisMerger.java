package br.com.gda.business.employeeList.info;

import java.util.List;

import br.com.gda.business.personList.info.PersolisInfo;
import br.com.gda.info.InfoMerger;

public final class EmplisMerger {
	public static EmplisInfo mergeWithPersolis(PersolisInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, PersolisInfo> merger = new EmplisMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, PersolisInfo> merger = new EmplisMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplisInfo mergeToSelect(EmplisInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, EmplisInfo> merger = new EmplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeToSelect(List<EmplisInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, EmplisInfo> merger = new EmplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
