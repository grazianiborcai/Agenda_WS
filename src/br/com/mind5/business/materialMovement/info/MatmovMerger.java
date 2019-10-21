package br.com.mind5.business.materialMovement.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatmovMerger {
	public static MatmovInfo mergeWithMat(MatInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger<MatmovInfo, MatInfo> merger = new MatmovMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithMat(List<MatInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger<MatmovInfo, MatInfo> merger = new MatmovMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeWithUsername(UsernameInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger<MatmovInfo, UsernameInfo> merger = new MatmovMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger<MatmovInfo, UsernameInfo> merger = new MatmovMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeToSelect(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger<MatmovInfo, MatmovInfo> merger = new MatmovMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeToSelect(List<MatmovInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger<MatmovInfo, MatmovInfo> merger = new MatmovMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeToDelete(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger<MatmovInfo, MatmovInfo> merger = new MatmovMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeToDelete(List<MatmovInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger<MatmovInfo, MatmovInfo> merger = new MatmovMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
