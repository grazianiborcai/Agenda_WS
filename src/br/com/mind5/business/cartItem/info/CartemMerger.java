package br.com.mind5.business.cartItem.info;

import java.util.List;

import br.com.mind5.business.cartItemSearch.info.CartemarchInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class CartemMerger {
	public static CartemInfo mergeWithCartemarch(CartemarchInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, CartemarchInfo> merger = new CartemMergerCartemarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithCartemarch(List<CartemarchInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, CartemarchInfo> merger = new CartemMergerCartemarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static CartemInfo mergeWithMatlis(MatlisInfo sourceOne, CartemInfo sourceTwo) {
		InfoMerger<CartemInfo, MatlisInfo> merger = new CartemMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CartemInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<CartemInfo> sourceTwos) {
		InfoMerger<CartemInfo, MatlisInfo> merger = new CartemMergerMatlis();		
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
