package br.com.mind5.business.scheduleWeek.info;

import java.util.List;

import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.calendarTimeStore.info.CalimoreInfo;
import br.com.mind5.business.calendarWeekYear.info.CaleekyInfo;
import br.com.mind5.business.customerList.info.CuslisInfo;
import br.com.mind5.business.employeeList.info.EmplisInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchedeekMerger {
	public static List<SchedeekInfo> mergeWithCalimore(List<SchedeekInfo> baseInfos, List<CalimoreInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, CalimoreInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeCalimore());
		InfoMergerV3<SchedeekInfo, CalimoreInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCalate(List<SchedeekInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeCalate());
		InfoMergerV3<SchedeekInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCaleeky(List<SchedeekInfo> baseInfos, List<CaleekyInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, CaleekyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeCaleeky());
		InfoMergerV3<SchedeekInfo, CaleekyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithCuslis(List<SchedeekInfo> baseInfos, List<CuslisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, CuslisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeCuslis());
		InfoMergerV3<SchedeekInfo, CuslisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithEmplis(List<SchedeekInfo> baseInfos, List<EmplisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, EmplisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeEmplis());
		InfoMergerV3<SchedeekInfo, EmplisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithMatlis(List<SchedeekInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeMatlis());
		InfoMergerV3<SchedeekInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedeekInfo> mergeWithStolis(List<SchedeekInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeStolis());
		InfoMergerV3<SchedeekInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SchedeekInfo> mergeWithSchedeekdat(List<SchedeekInfo> baseInfos, List<SchedeekdatInfo> selectedInfos) {
		InfoMergerBuilderV3<SchedeekInfo, SchedeekdatInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedeekVisiMergeSchedeekdat());
		InfoMergerV3<SchedeekInfo, SchedeekdatInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
