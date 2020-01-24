package br.com.mind5.business.scheduleWeek.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;

public final class SchedeekMerger {
	public static SchedeekInfo mergeWithCuslis(CuslisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, CuslisInfo> merger = new SchedeekMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, CuslisInfo> merger = new SchedeekMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithEmplis(EmplisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, EmplisInfo> merger = new SchedeekMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, EmplisInfo> merger = new SchedeekMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithMatlis(MatlisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, MatlisInfo> merger = new SchedeekMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, MatlisInfo> merger = new SchedeekMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedeekInfo mergeWithStolis(StolisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, StolisInfo> merger = new SchedeekMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, StolisInfo> merger = new SchedeekMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithSchedeekdat(SchedeekdatInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, SchedeekdatInfo> merger = new SchedeekMergerSchedeekdat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithSchedeekdat(List<SchedeekdatInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, SchedeekdatInfo> merger = new SchedeekMergerSchedeekdat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
