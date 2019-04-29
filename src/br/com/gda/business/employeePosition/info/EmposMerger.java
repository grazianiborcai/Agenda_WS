package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.business.masterData.info.PositionInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmposMerger {
	public static EmposInfo mergeWithPosition(PositionInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger<EmposInfo, PositionInfo> merger = new EmposMergerPosition();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeWithPosition(List<PositionInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger<EmposInfo, PositionInfo> merger = new EmposMergerPosition();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeWithUsername(UsernameInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger<EmposInfo, UsernameInfo> merger = new EmposMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger<EmposInfo, UsernameInfo> merger = new EmposMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmposInfo mergeToDelete(EmposInfo sourceOne, EmposInfo sourceTwo) {
		InfoMerger<EmposInfo, EmposInfo> merger = new EmposMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmposInfo> mergeToDelete(List<EmposInfo> sourceOnes, List<EmposInfo> sourceTwos) {
		InfoMerger<EmposInfo, EmposInfo> merger = new EmposMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
