package br.com.gda.file.fileImage.info;

import java.util.List;

import br.com.gda.file.fileImageSearch.info.FimarchInfo;
import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class FimgMerger {	
	public static FimgInfo mergeWithFimarch(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, FimarchInfo> merger = new FimgMergerFimarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithFimarch(List<FimarchInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, FimarchInfo> merger = new FimgMergerFimarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeWithFath(FathInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, FathInfo> merger = new FimgMergerFath();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithFath(List<FathInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, FathInfo> merger = new FimgMergerFath();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeWithUsername(UsernameInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, UsernameInfo> merger = new FimgMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, UsernameInfo> merger = new FimgMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeToUpdate(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToUpdate(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeToSelect(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToSelect(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static FimgInfo mergeToDelete(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToDelete(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger<FimgInfo, FimgInfo> merger = new FimgMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
