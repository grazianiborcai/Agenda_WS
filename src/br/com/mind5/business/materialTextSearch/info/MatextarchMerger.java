package br.com.mind5.business.materialTextSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;

public final class MatextarchMerger {	
	public static MatextarchInfo mergeToSelect(MatextarchInfo sourceOne, MatextarchInfo sourceTwo) {
		InfoMerger<MatextarchInfo, MatextarchInfo> merger = new MatextarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextarchInfo> mergeToSelect(List<MatextarchInfo> sourceOnes, List<MatextarchInfo> sourceTwos) {
		InfoMerger<MatextarchInfo, MatextarchInfo> merger = new MatextarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
