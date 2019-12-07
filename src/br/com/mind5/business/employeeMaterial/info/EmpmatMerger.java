package br.com.mind5.business.employeeMaterial.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.employeeMaterialSearch.info.EmpmarchInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class EmpmatMerger {
	public static EmpmatInfo mergeWithEmpmarch(EmpmarchInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, EmpmarchInfo> merger = new EmpmatMergerEmpmarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithEmpmarch(List<EmpmarchInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, EmpmarchInfo> merger = new EmpmatMergerEmpmarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeWithEmplis(EmplisInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, EmplisInfo> merger = new EmpmatMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, EmplisInfo> merger = new EmpmatMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeWithMatlis(MatlisInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, MatlisInfo> merger = new EmpmatMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, MatlisInfo> merger = new EmpmatMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeWithUsername(UsernameInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, UsernameInfo> merger = new EmpmatMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, UsernameInfo> merger = new EmpmatMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeToDelete(EmpmatInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = new EmpmatMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeToDelete(List<EmpmatInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = new EmpmatMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeToSelect(EmpmatInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = new EmpmatMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeToSelect(List<EmpmatInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, EmpmatInfo> merger = new EmpmatMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
