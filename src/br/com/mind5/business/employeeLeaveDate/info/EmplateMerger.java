package br.com.mind5.business.employeeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.masterData.info.TimezoneInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmplateMerger {
	public static EmplateInfo mergeWithTimezone(TimezoneInfo sourceOne, EmplateInfo sourceTwo) {
		InfoMerger<EmplateInfo, TimezoneInfo> merger = new EmplateMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplateInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<EmplateInfo> sourceTwos) {
		InfoMerger<EmplateInfo, TimezoneInfo> merger = new EmplateMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplateInfo mergeWithUsername(UsernameInfo sourceOne, EmplateInfo sourceTwo) {
		InfoMerger<EmplateInfo, UsernameInfo> merger = new EmplateMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplateInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmplateInfo> sourceTwos) {
		InfoMerger<EmplateInfo, UsernameInfo> merger = new EmplateMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplateInfo mergeToSelect(EmplateInfo sourceOne, EmplateInfo sourceTwo) {
		InfoMerger<EmplateInfo, EmplateInfo> merger = new EmplateMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplateInfo> mergeWithToSelect(List<EmplateInfo> sourceOnes, List<EmplateInfo> sourceTwos) {
		InfoMerger<EmplateInfo, EmplateInfo> merger = new EmplateMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplateInfo mergeToDelete(EmplateInfo sourceOne, EmplateInfo sourceTwo) {
		InfoMerger<EmplateInfo, EmplateInfo> merger = new EmplateMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplateInfo> mergeToDelete(List<EmplateInfo> sourceOnes, List<EmplateInfo> sourceTwos) {
		InfoMerger<EmplateInfo, EmplateInfo> merger = new EmplateMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
