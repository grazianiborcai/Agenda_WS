package br.com.mind5.file.fileImageList.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class FimistMerger {	
	public static FimistInfo mergeToSelect(FimistInfo sourceOne, FimistInfo sourceTwo) {
		InfoMerger<FimistInfo, FimistInfo> merger = new FimistMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimistInfo> mergeToSelect(List<FimistInfo> sourceOnes, List<FimistInfo> sourceTwos) {
		InfoMerger<FimistInfo, FimistInfo> merger = new FimistMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
