package br.com.mind5.business.materialText.info;

import java.util.List;

import br.com.mind5.business.materialTextDefault.info.MatextaultInfo;
import br.com.mind5.business.materialTextSearch.info.MatextarchInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class MatextMerger {
	public static MatextInfo mergeWithMatextarch(MatextarchInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, MatextarchInfo> merger = new MatextMergerMatextarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeWithMatextarch(List<MatextarchInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, MatextarchInfo> merger = new MatextMergerMatextarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static MatextInfo mergeWithMatextault(MatextaultInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, MatextaultInfo> merger = new MatextMergerMatextault();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeWithMatextault(List<MatextaultInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, MatextaultInfo> merger = new MatextMergerMatextault();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
	
	
	
	public static MatextInfo mergeToUpdate(MatextInfo sourceOne, MatextInfo sourceTwo) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<MatextInfo> mergeToUpdate(List<MatextInfo> sourceOnes, List<MatextInfo> sourceTwos) {
		InfoMerger<MatextInfo, MatextInfo> merger = new MatextMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
