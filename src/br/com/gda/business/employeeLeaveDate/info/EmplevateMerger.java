package br.com.gda.business.employeeLeaveDate.info;

import java.util.List;

import br.com.gda.business.masterData.info.TimezoneInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmplevateMerger {
	public static EmplevateInfo mergeWithTimezone(TimezoneInfo sourceOne, EmplevateInfo sourceTwo) {
		InfoMerger<EmplevateInfo, TimezoneInfo> merger = new EmplevateMergerTimezone();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplevateInfo> mergeWithTimezone(List<TimezoneInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		InfoMerger<EmplevateInfo, TimezoneInfo> merger = new EmplevateMergerTimezone();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplevateInfo mergeWithUsername(UsernameInfo sourceOne, EmplevateInfo sourceTwo) {
		InfoMerger<EmplevateInfo, UsernameInfo> merger = new EmplevateMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplevateInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		InfoMerger<EmplevateInfo, UsernameInfo> merger = new EmplevateMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplevateInfo mergeToSelect(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		InfoMerger<EmplevateInfo, EmplevateInfo> merger = new EmplevateMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplevateInfo> mergeWithToSelect(List<EmplevateInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		InfoMerger<EmplevateInfo, EmplevateInfo> merger = new EmplevateMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmplevateInfo mergeToDelete(EmplevateInfo sourceOne, EmplevateInfo sourceTwo) {
		InfoMerger<EmplevateInfo, EmplevateInfo> merger = new EmplevateMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmplevateInfo> mergeToDelete(List<EmplevateInfo> sourceOnes, List<EmplevateInfo> sourceTwos) {
		InfoMerger<EmplevateInfo, EmplevateInfo> merger = new EmplevateMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
