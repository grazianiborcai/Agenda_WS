package br.com.gda.file.fileUpload.info;

import java.util.List;

import br.com.gda.file.filePath.info.FathInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class FilupMerger {	
	public static FilupInfo mergeWithFath(FathInfo sourceOne, FilupInfo sourceTwo) {
		InfoMerger<FilupInfo, FathInfo> merger = new FilupMergerFath();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FilupInfo> mergeWithFath(List<FathInfo> sourceOnes, List<FilupInfo> sourceTwos) {
		InfoMerger<FilupInfo, FathInfo> merger = new FilupMergerFath();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FilupInfo mergeWithUsername(UsernameInfo sourceOne, FilupInfo sourceTwo) {
		InfoMerger<FilupInfo, UsernameInfo> merger = new FilupMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FilupInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<FilupInfo> sourceTwos) {
		InfoMerger<FilupInfo, UsernameInfo> merger = new FilupMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FilupInfo mergeToSelect(FilupInfo sourceOne, FilupInfo sourceTwo) {
		InfoMerger<FilupInfo, FilupInfo> merger = new FilupMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FilupInfo> mergeToSelect(List<FilupInfo> sourceOnes, List<FilupInfo> sourceTwos) {
		InfoMerger<FilupInfo, FilupInfo> merger = new FilupMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static FilupInfo mergeToDelete(FilupInfo sourceOne, FilupInfo sourceTwo) {
		InfoMerger<FilupInfo, FilupInfo> merger = new FilupMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FilupInfo> mergeToDelete(List<FilupInfo> sourceOnes, List<FilupInfo> sourceTwos) {
		InfoMerger<FilupInfo, FilupInfo> merger = new FilupMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
