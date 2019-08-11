package br.com.gda.business.schedule.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class OrderemMerger {
	public static ScheduInfo mergeWithMat(MatInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, MatInfo> merger = new OrderemMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithMat(List<MatInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, MatInfo> merger = new OrderemMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static ScheduInfo mergeWithMatsnap(MatsnapInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, MatsnapInfo> merger = new OrderemMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, MatsnapInfo> merger = new OrderemMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static ScheduInfo mergeWithStolis(StolisInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static ScheduInfo mergeWithEmplis(EmplisInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static ScheduInfo mergeWithWeekday(WeekdayInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithMatore(List<MatoreInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static ScheduInfo mergeWithMatore(MatoreInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static ScheduInfo mergeToSelect(ScheduInfo sourceOne, ScheduInfo sourceTwo) {
		InfoMerger<ScheduInfo, ScheduInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<ScheduInfo> mergeToSelect(List<ScheduInfo> sourceOnes, List<ScheduInfo> sourceTwos) {
		InfoMerger<ScheduInfo, ScheduInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
