package br.com.gda.business.scheduleWeek.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

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
	
	
	
	public static SchedeekInfo mergeWithMat(MatInfo sourceOne, SchedeekInfo sourceTwo) {
		InfoMerger<SchedeekInfo, MatInfo> merger = new SchedeekMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedeekInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedeekInfo> sourceTwos) {
		InfoMerger<SchedeekInfo, MatInfo> merger = new SchedeekMergerMat();		
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
