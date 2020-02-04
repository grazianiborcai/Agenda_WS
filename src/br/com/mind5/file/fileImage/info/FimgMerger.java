package br.com.mind5.file.fileImage.info;

import java.util.List;

import br.com.mind5.file.fileImageSearch.info.FimarchInfo;
import br.com.mind5.file.filePath.info.FathInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class FimgMerger {	
	public static FimgInfo mergeWithFimarch(FimarchInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FimarchInfo> merger = new FimgMergerFimarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithFimarch(List<FimarchInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FimarchInfo> merger = new FimgMergerFimarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeWithFath(FathInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FathInfo> merger = new FimgMergerFath();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithFath(List<FathInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FathInfo> merger = new FimgMergerFath();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeWithUsername(UsernameInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, UsernameInfo> merger = new FimgMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, UsernameInfo> merger = new FimgMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeToReplace(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToReplace();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToReplace(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToReplace();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeToSelect(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToSelect(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static FimgInfo mergeToDelete(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToDelete(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FimgInfo mergeToUpdate(FimgInfo sourceOne, FimgInfo sourceTwo) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FimgInfo> mergeToUpdate(List<FimgInfo> sourceOnes, List<FimgInfo> sourceTwos) {
		InfoMerger_<FimgInfo, FimgInfo> merger = new FimgMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
