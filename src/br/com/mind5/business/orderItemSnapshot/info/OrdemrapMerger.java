package br.com.mind5.business.orderItemSnapshot.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class OrdemrapMerger {
	public static OrdemrapInfo mergeWithMat(MatInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, MatInfo> merger = new OrdemrapMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMat(List<MatInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, MatInfo> merger = new OrdemrapMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeWithMatsnap(MatsnapInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, MatsnapInfo> merger = new OrdemrapMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, MatsnapInfo> merger = new OrdemrapMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrdemrapInfo mergeWithStolis(StolisInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, StolisInfo> merger = new OrdemrapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, EmplisInfo> merger = new OrdemrapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeWithEmplis(EmplisInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, EmplisInfo> merger = new OrdemrapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, StolisInfo> merger = new OrdemrapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OrdemrapInfo mergeWithWeekday(WeekdayInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, WeekdayInfo> merger = new OrdemrapMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, WeekdayInfo> merger = new OrdemrapMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrdemrapInfo mergeToSelect(OrdemrapInfo sourceOne, OrdemrapInfo sourceTwo) {
		InfoMerger_<OrdemrapInfo, OrdemrapInfo> merger = new OrdemrapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrdemrapInfo> mergeToSelect(List<OrdemrapInfo> sourceOnes, List<OrdemrapInfo> sourceTwos) {
		InfoMerger_<OrdemrapInfo, OrdemrapInfo> merger = new OrdemrapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
