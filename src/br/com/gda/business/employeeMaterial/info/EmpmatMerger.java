package br.com.gda.business.employeeMaterial.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class EmpmatMerger {
	public static EmpmatInfo mergeWithEmp(EmpInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, EmpInfo> merger = new EmpmatMergerEmp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithEmp(List<EmpInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, EmpInfo> merger = new EmpmatMergerEmp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static EmpmatInfo mergeWithMat(MatInfo sourceOne, EmpmatInfo sourceTwo) {
		InfoMerger<EmpmatInfo, MatInfo> merger = new EmpmatMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<EmpmatInfo> mergeWithMat(List<MatInfo> sourceOnes, List<EmpmatInfo> sourceTwos) {
		InfoMerger<EmpmatInfo, MatInfo> merger = new EmpmatMergerMat();		
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
