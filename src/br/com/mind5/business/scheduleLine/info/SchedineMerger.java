package br.com.mind5.business.scheduleLine.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.orderItemList.info.OrdemistInfo;
import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.business.scheduleAuthorization.info.SchedauthInfo;
import br.com.mind5.business.scheduleLineSnapshot.info.SchedinapInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.scheduleStatus.info.SchedatusInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SchedineMerger {
	public static List<SchedineInfo> mergeWithSchedauth(List<SchedineInfo> baseInfos, List<SchedauthInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedauthInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeSchedauth());
		InfoMergerV3<SchedineInfo, SchedauthInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithCalate(List<SchedineInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeCalate());
		InfoMergerV3<SchedineInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithWeekday(List<SchedineInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeWeekday());
		InfoMergerV3<SchedineInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrdist(List<SchedineInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, OrdistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeOrdist());
		InfoMergerV3<SchedineInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithEmplis(List<SchedineInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeEmplis());
		InfoMergerV3<SchedineInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedatus(List<SchedineInfo> baseInfos, List<SchedatusInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedatusInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeSchedatus());
		InfoMergerV3<SchedineInfo, SchedatusInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedineInfo> mergeWithStolis(List<SchedineInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeStolis());
		InfoMergerV3<SchedineInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithOrdemist(List<SchedineInfo> baseInfos, List<OrdemistInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, OrdemistInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeOrdemist());
		InfoMergerV3<SchedineInfo, OrdemistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithCuslis(List<SchedineInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeCuslis());
		InfoMergerV3<SchedineInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithSchedinap(List<SchedineInfo> baseInfos, List<SchedinapInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedinapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeSchedinap());
		InfoMergerV3<SchedineInfo, SchedinapInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithUsername(List<SchedineInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeUsername());
		InfoMergerV3<SchedineInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeWithMatlis(List<SchedineInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeMatlis());
		InfoMergerV3<SchedineInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToSelect(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeToSelect());
		InfoMergerV3<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToUpdate(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeToUpdate());
		InfoMergerV3<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedineInfo> mergeToMove(List<SchedineInfo> baseInfos, List<SchedineInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedineInfo, SchedineInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedineVisiMergeToMove());
		InfoMergerV3<SchedineInfo, SchedineInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
