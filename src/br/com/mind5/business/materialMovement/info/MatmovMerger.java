package br.com.mind5.business.materialMovement.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatmovMerger {
	public static MatmovInfo mergeWithMatlis(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger<MatmovInfo, MatlisInfo> merger = new MatmovMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger<MatmovInfo, MatlisInfo> merger = new MatmovMergerMatlis();		
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
}
