package br.com.mind5.file.fileImageSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class FimarchMerger {	
	public static FimarchInfo mergeToSelect(FimarchInfo sourceOne, FimarchInfo sourceTwo) {
		InfoMerger_<FimarchInfo, FimarchInfo> merger = new FimarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimarchInfo> mergeToSelect(List<FimarchInfo> sourceOnes, List<FimarchInfo> sourceTwos) {
		InfoMerger_<FimarchInfo, FimarchInfo> merger = new FimarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
