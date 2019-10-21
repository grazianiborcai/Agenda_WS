package br.com.mind5.business.scheduleMonth.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;

public final class SchedmonMerger {
	public static SchedmonInfo mergeWithEmplis(EmplisInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger<SchedmonInfo, EmplisInfo> merger = new SchedmonMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger<SchedmonInfo, EmplisInfo> merger = new SchedmonMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedmonInfo mergeWithMat(MatInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger<SchedmonInfo, MatInfo> merger = new SchedmonMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger<SchedmonInfo, MatInfo> merger = new SchedmonMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedmonInfo mergeWithStolis(StolisInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger<SchedmonInfo, StolisInfo> merger = new SchedmonMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger<SchedmonInfo, StolisInfo> merger = new SchedmonMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedmonInfo mergeWithSchedonthat(SchedonthatInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger<SchedmonInfo, SchedonthatInfo> merger = new SchedmonMergerSchedonthat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithSchedonthat(List<SchedonthatInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger<SchedmonInfo, SchedonthatInfo> merger = new SchedmonMergerSchedonthat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
