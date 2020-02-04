package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class MatextarchMerger {	
	public static MatextarchInfo mergeToSelect(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {
		InfoMerger_<MatextarchInfo, MatextarchInfo> merger = new MatextarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextarchInfo> mergeToSelect(List<MatextarchInfo> sourceOnes, List<MatextarchInfo> sourceTwos) {
		InfoMerger_<MatextarchInfo, MatextarchInfo> merger = new MatextarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
