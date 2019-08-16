package br.com.gda.business.scheduleLine.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.userList.info.UselisInfo;
import br.com.gda.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static SchedineInfo mergeWithUsername(UsernameInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithUselis(UselisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, UselisInfo> merger = new SchedineMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, UselisInfo> merger = new SchedineMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithCuslis(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithEmplis(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithStolis(StolisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithMat(MatInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeToSelect(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
