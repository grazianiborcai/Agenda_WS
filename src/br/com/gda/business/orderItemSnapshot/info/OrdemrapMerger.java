package br.com.gda.business.orderItemSnapshot.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class OrdemrapMerger {
	public static OrdemrapInfo mergeWithMat(MatInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, MatInfo> merger = new OrdemrapMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMat(List<MatInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, MatInfo> merger = new OrdemrapMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeWithMatsnap(MatsnapInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, MatsnapInfo> merger = new OrdemrapMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, MatsnapInfo> merger = new OrdemrapMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdemrapInfo mergeWithStolis(StolisInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, StolisInfo> merger = new OrdemrapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, EmplisInfo> merger = new OrdemrapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeWithEmplis(EmplisInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, EmplisInfo> merger = new OrdemrapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, StolisInfo> merger = new OrdemrapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OrdemrapInfo mergeWithWeekday(WeekdayInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, WeekdayInfo> merger = new OrdemrapMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, WeekdayInfo> merger = new OrdemrapMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeToSelect(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger<OrdemrapInfo, OrdemrapInfo> merger = new OrdemrapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeToSelect(List<OrdemrapInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger<OrdemrapInfo, OrdemrapInfo> merger = new OrdemrapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
