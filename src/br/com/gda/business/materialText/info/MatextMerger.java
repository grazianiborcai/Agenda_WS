package br.com.gda.business.materialText.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class MatextMerger {
	public static MatextInfo mergeWithUsername(UsernameInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, UsernameInfo> merger = new MatextMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, UsernameInfo> merger = new MatextMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatextInfo mergeToSelect(MatextInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeToSelect(List<MatextInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatextInfo mergeToDelete(MatextInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeToDelete(List<MatextInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
