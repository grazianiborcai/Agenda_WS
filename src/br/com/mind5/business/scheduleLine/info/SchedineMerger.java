package br.com.mind5.business.scheduleLine.info;

import java.util.List;

import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.masterData.info.ScheduleStatusInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.order.info.OrderInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMergerOneToMany_;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static SchedineInfo mergeWithWeekday(WeekdayInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, WeekdayInfo> merger = new SchedineMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, WeekdayInfo> merger = new SchedineMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithEmplis(EmplisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithEmplis(List<EmplisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, EmplisInfo> merger = new SchedineMergerEmplis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithScheduleStatus(ScheduleStatusInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, ScheduleStatusInfo> merger = new SchedineMergerScheduleStatus();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithScheduleStatus(List<ScheduleStatusInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, ScheduleStatusInfo> merger = new SchedineMergerScheduleStatus();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithStolis(StolisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, StolisInfo> merger = new SchedineMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithOrdist(OrdistInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, OrdistInfo> merger = new SchedineMergerOrdist();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrdist(List<OrdistInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, OrdistInfo> merger = new SchedineMergerOrdist();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrder(OrderInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMergerOneToMany_<SchedineInfo, OrderInfo> merger = new SchedineMergerOrder();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrder(List<OrderInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMergerOneToMany_<SchedineInfo, OrderInfo> merger = new SchedineMergerOrder();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithCuslis(CuslisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<CuslisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, CuslisInfo> merger = new SchedineMergerCuslis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithSchedinap(SchedinapInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedinap(List<SchedinapInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, SchedinapInfo> merger = new SchedineMergerSchedinap();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeWithUsername(UsernameInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, UsernameInfo> merger = new SchedineMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeWithMatlis(MatlisInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, MatlisInfo> merger = new SchedineMergerMatlis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeWithMatlis(List<MatlisInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, MatlisInfo> merger = new SchedineMergerMatlis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static SchedineInfo mergeToSelect(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeToUpdate(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToUpdate(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static SchedineInfo mergeToMove(SchedineInfo sourceOne, SchedineInfo sourceTwo) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToMove();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<SchedineInfo> mergeToMove(List<SchedineInfo> sourceOnes, List<SchedineInfo> sourceTwos) {
		InfoMerger_<SchedineInfo, SchedineInfo> merger = new SchedineMergerToMove();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
