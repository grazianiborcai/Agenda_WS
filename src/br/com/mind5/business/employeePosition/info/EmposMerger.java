package br.com.mind5.business.employeePosition.info;

import java.util.List;

import br.com.mind5.business.employeePositionSearch.info.EmposarchInfo;
import br.com.mind5.business.masterData.info.PositionInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmposMerger {
	public static EmposInfo mergeWithEmposarch(EmposarchInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger_<EmposInfo, EmposarchInfo> merger = new EmposMergerEmposarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeWithEmposarch(List<EmposarchInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger_<EmposInfo, EmposarchInfo> merger = new EmposMergerEmposarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeWithPosition(PositionInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger_<EmposInfo, PositionInfo> merger = new EmposMergerPosition();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeWithPosition(List<PositionInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger_<EmposInfo, PositionInfo> merger = new EmposMergerPosition();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeWithUsername(UsernameInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger_<EmposInfo, UsernameInfo> merger = new EmposMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger_<EmposInfo, UsernameInfo> merger = new EmposMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeToDelete(EmposInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger_<EmposInfo, EmposInfo> merger = new EmposMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeToDelete(List<EmposInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger_<EmposInfo, EmposInfo> merger = new EmposMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeToSelect(EmposInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger_<EmposInfo, EmposInfo> merger = new EmposMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeToSelect(List<EmposInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger_<EmposInfo, EmposInfo> merger = new EmposMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
