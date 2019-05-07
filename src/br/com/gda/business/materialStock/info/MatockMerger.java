package br.com.gda.business.materialStock.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class MatockMerger {
	public static MatockInfo mergeToSelect(MatockInfo sourceOne, MatockInfo sourceTwo) {
		InfoMerger<MatockInfo, MatockInfo> merger = new MatockMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatockInfo> mergeToSelect(List<MatockInfo> sourceOnes, List<MatockInfo> sourceTwos) {
		InfoMerger<MatockInfo, MatockInfo> merger = new MatockMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatockInfo mergeToUpdate(MatockInfo sourceOne, MatockInfo sourceTwo) {
		InfoMerger<MatockInfo, MatockInfo> merger = new MatockMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatockInfo> mergeToUpdate(List<MatockInfo> sourceOnes, List<MatockInfo> sourceTwos) {
		InfoMerger<MatockInfo, MatockInfo> merger = new MatockMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
