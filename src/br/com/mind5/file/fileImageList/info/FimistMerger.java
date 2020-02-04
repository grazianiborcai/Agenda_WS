package br.com.mind5.file.fileImageList.info;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.info.obsolete.InfoMerger_;

public final class FimistMerger {	
	public static FimistInfo mergeWithFimarch(FimarchInfo sourceOne, FimistInfo sourceTwo) {
		InfoMerger_<FimistInfo, FimarchInfo> merger = new FimistMergerFimarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimistInfo> mergeWithFimarch(List<FimarchInfo> sourceOnes, List<FimistInfo> sourceTwos) {
		InfoMerger_<FimistInfo, FimarchInfo> merger = new FimistMergerFimarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimistInfo mergeToSelect(FimistInfo sourceOne, FimistInfo sourceTwo) {
		InfoMerger_<FimistInfo, FimistInfo> merger = new FimistMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimistInfo> mergeToSelect(List<FimistInfo> sourceOnes, List<FimistInfo> sourceTwos) {
		InfoMerger_<FimistInfo, FimistInfo> merger = new FimistMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
