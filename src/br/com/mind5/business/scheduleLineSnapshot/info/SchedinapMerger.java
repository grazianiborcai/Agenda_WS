package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class SchedinapMerger {
	public static SchedinapInfo mergeWithUselis(UselisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, UselisInfo> merger = new SchedinapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, UselisInfo> merger = new SchedinapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedinapInfo mergeWithCuslis(CuslisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, CuslisInfo> merger = new SchedinapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, CuslisInfo> merger = new SchedinapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithEmplis(EmplisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, EmplisInfo> merger = new SchedinapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, EmplisInfo> merger = new SchedinapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithStolis(StolisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, StolisInfo> merger = new SchedinapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, StolisInfo> merger = new SchedinapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithMatsnap(MatsnapInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, MatsnapInfo> merger = new SchedinapMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, MatsnapInfo> merger = new SchedinapMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithMat(MatInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, MatInfo> merger = new SchedinapMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, MatInfo> merger = new SchedinapMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeToSelect(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger<SchedinapInfo, SchedinapInfo> merger = new SchedinapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeToSelect(List<SchedinapInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger<SchedinapInfo, SchedinapInfo> merger = new SchedinapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
