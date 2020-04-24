package br.com.mind5.business.orderItem.info;

import java.util.List;

import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.materialStore.info.MatoreInfo;
import br.com.mind5.business.orderItemSearch.info.OrdemarchInfo;
import br.com.mind5.business.orderItemSnapshot.info.OrdemrapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class OrderemMerger {
	public static OrderemInfo mergeWithOrdemarch(OrdemarchInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, OrdemarchInfo> merger = new OrderemMergerOrdemarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithOrdemarch(List<OrdemarchInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, OrdemarchInfo> merger = new OrderemMergerOrdemarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithOrdemrap(OrdemrapInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, OrdemrapInfo> merger = new OrderemMergerOrdemrap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithOrdemrap(List<OrdemrapInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, OrdemrapInfo> merger = new OrderemMergerOrdemrap();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static OrderemInfo mergeWithUsername(UsernameInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, UsernameInfo> merger = new OrderemMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, UsernameInfo> merger = new OrderemMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithMatlis(MatlisInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, MatlisInfo> merger = new OrderemMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, MatlisInfo> merger = new OrderemMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithStolis(StolisInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithEmplis(EmplisInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, EmplisInfo> merger = new OrderemMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, StolisInfo> merger = new OrderemMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static OrderemInfo mergeWithWeekday(WeekdayInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithMatore(List<MatoreInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeWithMatore(MatoreInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, MatoreInfo> merger = new OrderemMergerMatore();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, WeekdayInfo> merger = new OrderemMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}		
	
	
	
	public static OrderemInfo mergeToSelect(OrderemInfo sourceOne, OrderemInfo sourceTwo) {
		InfoMerger_<OrderemInfo, OrderemInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<OrderemInfo> mergeToSelect(List<OrderemInfo> sourceOnes, List<OrderemInfo> sourceTwos) {
		InfoMerger_<OrderemInfo, OrderemInfo> merger = new OrderemMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
