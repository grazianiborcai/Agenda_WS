package br.com.mind5.business.company.info;

import java.util.List;

import br.com.mind5.business.companySnapshot.info.CompnapInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CompMerger {
	public static CompInfo mergeWithCompnap(CompnapInfo sourceOne, CompInfo sourceTwo) {
		InfoMerger<CompInfo, CompnapInfo> merger = new CompMergerCompnap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompInfo> mergeWithCompnap(List<CompnapInfo> sourceOnes, List<CompInfo> sourceTwos) {
		InfoMerger<CompInfo, CompnapInfo> merger = new CompMergerCompnap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
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
	
	
	
	public static CompInfo mergeToUpdate(CompInfo sourceOne, CompInfo sourceTwo) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompInfo> mergeToUpdate(List<CompInfo> sourceOnes, List<CompInfo> sourceTwos) {
		InfoMerger<CompInfo, CompInfo> merger = new CompMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
