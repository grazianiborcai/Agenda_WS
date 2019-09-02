package br.com.gda.business.scheduleLine.info;

import java.util.List;

import br.com.gda.business.customerList.info.CuslisInfo;
import br.com.gda.business.employeeList.info.EmplisInfo;
import br.com.gda.business.masterData.info.ScheduleStatusInfo;
import br.com.gda.business.masterData.info.WeekdayInfo;
import br.com.gda.business.material.info.MatInfo;
import br.com.gda.business.order.info.OrderInfo;
import br.com.gda.business.orderList.info.OrdistInfo;
import br.com.gda.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.gda.business.scheduleSearch.info.SchedarchInfo;
import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMerger;
import br.com.gda.info.InfoMergerOneToMany;
import br.com.gda.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static SchedineInfo mergeWithDuple(SchedarchInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedarchInfo> merger = new SchedineMergerDuple();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithDuple(List<SchedarchInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedarchInfo> merger = new SchedineMergerDuple();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, WeekdayInfo> merger = new SchedineMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, WeekdayInfo> merger = new SchedineMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithEmplis(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithScheduleStatus(ScheduleStatusInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, ScheduleStatusInfo> merger = new SchedineMergerScheduleStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithScheduleStatus(List<ScheduleStatusInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, ScheduleStatusInfo> merger = new SchedineMergerScheduleStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithStolis(StolisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithOrdist(OrdistInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, OrdistInfo> merger = new SchedineMergerOrdist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrdist(List<OrdistInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, OrdistInfo> merger = new SchedineMergerOrdist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrder(OrderInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMergerOneToMany<SchedineInfo, OrderInfo> merger = new SchedineMergerOrder();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrder(List<OrderInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMergerOneToMany<SchedineInfo, OrderInfo> merger = new SchedineMergerOrder();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithCuslis(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithSchedinap(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedinap(List<SchedinapInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithUsername(UsernameInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithMat(MatInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithMat(List<MatInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, MatInfo> merger = new SchedineMergerMat();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeToSelect(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeToUpdate(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToUpdate(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeToMove(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToMove();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToMove(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger<SchedineInfo, SchedineInfo> merger = new SchedineMergerToMove();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
