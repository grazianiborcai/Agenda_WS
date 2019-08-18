package br.com.gda.business.scheduleLine.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static SchedineInfo mergeWithCuslis(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithSchedinap(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedinap(List<SchedinapInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithUsername(UsernameInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithMat(MatInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeToSelect(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeToUpdate(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToUpdate(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
