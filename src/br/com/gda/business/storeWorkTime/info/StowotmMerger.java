package br.com.gda.business.storeWorkTime.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class StowotmMerger {
	public static StowotmInfo mergeWithUsername(UsernameInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger<StowotmInfo, UsernameInfo> merger = new StowotmMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger<StowotmInfo, UsernameInfo> merger = new StowotmMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeToSelect(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger<StowotmInfo, StowotmInfo> merger = new StowotmMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeToSelect(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger<StowotmInfo, StowotmInfo> merger = new StowotmMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeToDelete(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger<StowotmInfo, StowotmInfo> merger = new StowotmMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeToDelete(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger<StowotmInfo, StowotmInfo> merger = new StowotmMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
