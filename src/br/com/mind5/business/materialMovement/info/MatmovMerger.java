package br.com.mind5.business.materialMovement.info;

import java.util.List;

import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialMovementSearch.info.MatmarchInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatmovMerger {
	public static MatmovInfo mergeWithMatmarch(MatmarchInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger_<MatmovInfo, MatmarchInfo> merger = new MatmovMergerMatmarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatmarch(List<MatmarchInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger_<MatmovInfo, MatmarchInfo> merger = new MatmovMergerMatmarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeWithMatock(MatockInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger_<MatmovInfo, MatockInfo> merger = new MatmovMergerMatock();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatock(List<MatockInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger_<MatmovInfo, MatockInfo> merger = new MatmovMergerMatock();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeWithMatlis(MatlisInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger_<MatmovInfo, MatlisInfo> merger = new MatmovMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger_<MatmovInfo, MatlisInfo> merger = new MatmovMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeWithUsername(UsernameInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger_<MatmovInfo, UsernameInfo> merger = new MatmovMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger_<MatmovInfo, UsernameInfo> merger = new MatmovMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatmovInfo mergeToSelect(MatmovInfo sourceOne, MatmovInfo sourceTwo) {
		InfoMerger_<MatmovInfo, MatmovInfo> merger = new MatmovMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatmovInfo> mergeToSelect(List<MatmovInfo> sourceOnes, List<MatmovInfo> sourceTwos) {
		InfoMerger_<MatmovInfo, MatmovInfo> merger = new MatmovMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
