package br.com.gda.business.planningTime_.info;

import java.util.List;

import br.com.gda.business.employee.info.EmpInfo;
import br.com.gda.business.employeeMaterial.info.EmpmatInfo;
import br.com.gda.business.employeeWorkTime.info.EmpwotmInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.store.info.StoreInfo;
import br.com.gda.business.storeWorkTime.info.StowotmInfo;
import br.com.gda.info.InfoMerger;

public final class PlanMerger {
	public static PlanInfo mergeWithEmp(EmpInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, EmpInfo> merger = new PlanMergerEmp();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithEmp(List<EmpInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, EmpInfo> merger = new PlanMergerEmp();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithEmpmat(EmpmatInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, EmpmatInfo> merger = new PlanMergerEmpmat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithEmpmat(List<EmpmatInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, EmpmatInfo> merger = new PlanMergerEmpmat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithEmpwotm(EmpwotmInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, EmpwotmInfo> merger = new PlanMergerEmpwotm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithEmpwotm(List<EmpwotmInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, EmpwotmInfo> merger = new PlanMergerEmpwotm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithMat(MatInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, MatInfo> merger = new PlanMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithMat(List<MatInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, MatInfo> merger = new PlanMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithStore(StoreInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, StoreInfo> merger = new PlanMergerStore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithStore(List<StoreInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, StoreInfo> merger = new PlanMergerStore();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithStowotm(StowotmInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, StowotmInfo> merger = new PlanMergerStowotm();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithStowotm(List<StowotmInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, StowotmInfo> merger = new PlanMergerStowotm();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static PlanInfo mergeWithWeekday(WeekdayInfo sourceOne, PlanInfo sourceTwo) {
		InfoMerger<PlanInfo, WeekdayInfo> merger = new PlanMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<PlanInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<PlanInfo> sourceTwos) {
		InfoMerger<PlanInfo, WeekdayInfo> merger = new PlanMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
