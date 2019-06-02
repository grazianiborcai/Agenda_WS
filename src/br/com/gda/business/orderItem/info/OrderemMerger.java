package br.com.gda.business.orderItem.info;

import java.util.List;

import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.materialStore.info.MatoreInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;

public final class OrderemMerger {
	public static OrderemInfo mergeWithMat(MatInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, MatInfo> merger = new OrderemMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithMat(List<MatInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, MatInfo> merger = new OrderemMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithStolis(StolisInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithEmplis(EmplisInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OrderemInfo mergeWithWeekday(WeekdayInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatore(List<MatoreInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithMatore(MatoreInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeToSelect(OrderemInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger<OrderemInfo, OrderemInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeToSelect(List<OrderemInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger<OrderemInfo, OrderemInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
