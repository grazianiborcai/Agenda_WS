package br.com.mind5.business.scheduleWeek.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class SchedeekMerger {
	public static SchedeekInfo mergeWithCuslis(CuslisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger_<SchedeekInfo, CuslisInfo> merger = new SchedeekMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger_<SchedeekInfo, CuslisInfo> merger = new SchedeekMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithEmplis(EmplisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger_<SchedeekInfo, EmplisInfo> merger = new SchedeekMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger_<SchedeekInfo, EmplisInfo> merger = new SchedeekMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithMatlis(MatlisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger_<SchedeekInfo, MatlisInfo> merger = new SchedeekMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger_<SchedeekInfo, MatlisInfo> merger = new SchedeekMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedeekInfo mergeWithStolis(StolisInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger_<SchedeekInfo, StolisInfo> merger = new SchedeekMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger_<SchedeekInfo, StolisInfo> merger = new SchedeekMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedeekInfo mergeWithSchedeekdat(SchedeekdatInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger_<SchedeekInfo, SchedeekdatInfo> merger = new SchedeekMergerSchedeekdat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithSchedeekdat(List<SchedeekdatInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger_<SchedeekInfo, SchedeekdatInfo> merger = new SchedeekMergerSchedeekdat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
