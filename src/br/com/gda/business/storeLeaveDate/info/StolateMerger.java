package br.com.gda.business.storeLeaveDate.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class StolateMerger {
	public static StolateInfo mergeWithUsername(UsernameInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger<StolateInfo, UsernameInfo> merger = new StolateMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger<StolateInfo, UsernameInfo> merger = new StolateMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolateInfo mergeToSelect(StolateInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger<StolateInfo, StolateInfo> merger = new StolateMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeToSelect(List<StolateInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger<StolateInfo, StolateInfo> merger = new StolateMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolateInfo mergeToDeleteSelect(StolateInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger<StolateInfo, StolateInfo> merger = new StolateMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeToDelete(List<StolateInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger<StolateInfo, StolateInfo> merger = new StolateMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
