package br.com.mind5.business.employeeList.info;

import java.util.List;

import br.com.mind5.business.employeeSearch.info.EmparchInfo;
import br.com.mind5.business.personListRestricted.info.PersoresInfo;
import br.com.mind5.business.personSearch.info.PerarchInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class EmplisMerger {
	public static EmplisInfo mergeWithEmparch(EmparchInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger_<EmplisInfo, EmparchInfo> merger = new EmplisMergerEmparch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithEmparch(List<EmparchInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger_<EmplisInfo, EmparchInfo> merger = new EmplisMergerEmparch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplisInfo mergeWithPerarch(PerarchInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger_<EmplisInfo, PerarchInfo> merger = new EmplisMergerPerarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithPerarch(List<PerarchInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger_<EmplisInfo, PerarchInfo> merger = new EmplisMergerPerarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static EmplisInfo mergeWithFimist(FimistInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger_<EmplisInfo, FimistInfo> merger = new EmplisMergerFimist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithFimist(List<FimistInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger_<EmplisInfo, FimistInfo> merger = new EmplisMergerFimist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplisInfo mergeWithPersores(PersoresInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger_<EmplisInfo, PersoresInfo> merger = new EmplisMergerPersores();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeWithPersores(List<PersoresInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger_<EmplisInfo, PersoresInfo> merger = new EmplisMergerPersores();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplisInfo mergeToSelect(EmplisInfo sourceOne, EmplisInfo sourceTwo) {
		InfoMerger_<EmplisInfo, EmplisInfo> merger = new EmplisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplisInfo> mergeToSelect(List<EmplisInfo> sourceOnes, List<EmplisInfo> sourceTwos) {
		InfoMerger_<EmplisInfo, EmplisInfo> merger = new EmplisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
