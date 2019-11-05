package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;

public final class EmplisMerger {
	public static EmplisInfo mergeWithFimist(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, FimistInfo> merger = new EmplisMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, FimistInfo> merger = new EmplisMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
