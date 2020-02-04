package br.com.mind5.business.scheduleMonth.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleMonthData.info.SchedonthatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedmonMerger {
	public static SchedmonInfo mergeWithEmplis(EmplisInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger_<SchedmonInfo, EmplisInfo> merger = new SchedmonMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger_<SchedmonInfo, EmplisInfo> merger = new SchedmonMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedmonInfo mergeWithMatlis(MatlisInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger_<SchedmonInfo, MatlisInfo> merger = new SchedmonMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger_<SchedmonInfo, MatlisInfo> merger = new SchedmonMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedmonInfo mergeWithStolis(StolisInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger_<SchedmonInfo, StolisInfo> merger = new SchedmonMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger_<SchedmonInfo, StolisInfo> merger = new SchedmonMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedmonInfo mergeWithSchedonthat(SchedonthatInfo sourceOne, SchedmonInfo sourceTwo) {
		InfoMerger_<SchedmonInfo, SchedonthatInfo> merger = new SchedmonMergerSchedonthat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedmonInfo> mergeWithSchedonthat(List<SchedonthatInfo> sourceOnes, List<SchedmonInfo> sourceTwos) {
		InfoMerger_<SchedmonInfo, SchedonthatInfo> merger = new SchedmonMergerSchedonthat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
