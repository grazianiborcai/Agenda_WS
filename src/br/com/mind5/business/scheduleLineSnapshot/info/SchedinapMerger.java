package br.com.mind5.business.scheduleLineSnapshot.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialSnapshot.info.MatsnapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.userList.info.UselisInfo;

public final class SchedinapMerger {
	public static SchedinapInfo mergeWithUselis(UselisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, UselisInfo> merger = new SchedinapMergerUselis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithUselis(List<UselisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, UselisInfo> merger = new SchedinapMergerUselis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedinapInfo mergeWithCuslis(CuslisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, CuslisInfo> merger = new SchedinapMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, CuslisInfo> merger = new SchedinapMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithEmplis(EmplisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, EmplisInfo> merger = new SchedinapMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, EmplisInfo> merger = new SchedinapMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithStolis(StolisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, StolisInfo> merger = new SchedinapMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, StolisInfo> merger = new SchedinapMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithMatsnap(MatsnapInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, MatsnapInfo> merger = new SchedinapMergerMatsnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatsnap(List<MatsnapInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, MatsnapInfo> merger = new SchedinapMergerMatsnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeWithMatlis(MatlisInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, MatlisInfo> merger = new SchedinapMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, MatlisInfo> merger = new SchedinapMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedinapInfo mergeToSelect(SchedinapInfo sourceOne, SchedinapInfo sourceTwo) {
		InfoMerger_<SchedinapInfo, SchedinapInfo> merger = new SchedinapMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedinapInfo> mergeToSelect(List<SchedinapInfo> sourceOnes, List<SchedinapInfo> sourceTwos) {
		InfoMerger_<SchedinapInfo, SchedinapInfo> merger = new SchedinapMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
