package br.com.gda.business.cartItem.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

public final class CartemMerger {
	public static CartemInfo mergeWithMat(MatInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, MatInfo> merger = new CartemMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithMat(List<MatInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, MatInfo> merger = new CartemMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithStolis(StolisInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, StolisInfo> merger = new CartemMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, EmplisInfo> merger = new CartemMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithEmplis(EmplisInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, EmplisInfo> merger = new CartemMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, StolisInfo> merger = new CartemMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartemInfo mergeWithUsername(UsernameInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, UsernameInfo> merger = new CartemMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, UsernameInfo> merger = new CartemMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithWeekday(WeekdayInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, WeekdayInfo> merger = new CartemMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithMatore(List<MatoreInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, MatoreInfo> merger = new CartemMergerMatore();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithMatore(MatoreInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, MatoreInfo> merger = new CartemMergerMatore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, WeekdayInfo> merger = new CartemMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static CartemInfo mergeToUpdate(CartemInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeToUpdate(List<CartemInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeToSelect(CartemInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeToSelect(List<CartemInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CartemInfo> merger = new CartemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
