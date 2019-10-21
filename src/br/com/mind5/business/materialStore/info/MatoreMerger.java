package br.com.mind5.business.materialStore.info;

import java.util.List;

import br.com.mind5.business.material.info.MatInfo;
import br.com.mind5.business.materialStock.info.MatockInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatoreMerger {
	public static MatoreInfo mergeWithMat(MatInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatInfo> merger = new MatoreMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMat(List<MatInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatInfo> merger = new MatoreMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithMatock(MatockInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatockInfo> merger = new MatoreMergerMatock();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithMatock(List<MatockInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatockInfo> merger = new MatoreMergerMatock();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeWithUsername(UsernameInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, UsernameInfo> merger = new MatoreMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, UsernameInfo> merger = new MatoreMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeToSelect(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeToSelect(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatoreInfo mergeToDelete(MatoreInfo sourceOne, MatoreInfo sourceTwo) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatoreInfo> mergeToDelete(List<MatoreInfo> sourceOnes, List<MatoreInfo> sourceTwos) {
		InfoMerger<MatoreInfo, MatoreInfo> merger = new MatoreMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
