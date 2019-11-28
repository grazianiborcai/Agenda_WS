package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;

public final class EmplisMerger {
	public static EmplisInfo mergeWithEmparch(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, EmparchInfo> merger = new EmplisMergerEmparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithEmparch(List<EmparchInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, EmparchInfo> merger = new EmplisMergerEmparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplisInfo mergeWithPerarch(PerarchInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger<EmplisInfo, PerarchInfo> merger = new EmplisMergerPerarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithPerarch(List<PerarchInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger<EmplisInfo, PerarchInfo> merger = new EmplisMergerPerarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
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
