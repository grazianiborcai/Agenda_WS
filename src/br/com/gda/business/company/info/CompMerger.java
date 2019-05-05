package br.com.gda.business.company.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CompMerger {
	public static CompInfo mergeWithUsername(UsernameInfo sourceOne, CompInfo sourceTwo) {
		InfoMerger<CompInfo, UsernameInfo> merger = new CompMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CompInfo> sourceTwos) {
		InfoMerger<CompInfo, UsernameInfo> merger = new CompMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CompInfo mergeToDelete(CompInfo sourceOne, CompInfo sourceTwo) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompInfo> mergeToDelete(List<CompInfo> sourceOnes, List<CompInfo> sourceTwos) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static CompInfo mergeToSelect(CompInfo sourceOne, CompInfo sourceTwo) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompInfo> mergeToSelect(List<CompInfo> sourceOnes, List<CompInfo> sourceTwos) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
