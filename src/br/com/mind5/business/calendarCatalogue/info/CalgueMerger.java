package br.com.mind5.business.calendarCatalogue.info;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.dayParting.info.DaypartInfo;
import br.com.mind5.masterData.moonPhase.info.MoonaseInfo;
import br.com.mind5.masterData.weekday.info.WeekdayInfo;

public final class CalgueMerger {
	public static List<CalgueInfo> mergeWithMoonase(List<CalgueInfo> baseInfos, List<MoonaseInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, MoonaseInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeMoonase());
		InfoMergerV3<CalgueInfo, MoonaseInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithStolis(List<CalgueInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, StolisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeStolis());
		InfoMergerV3<CalgueInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithMatlis(List<CalgueInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, MatlisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeMatlis());
		InfoMergerV3<CalgueInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithDaypart(List<CalgueInfo> baseInfos, List<DaypartInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, DaypartInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeDaypart());
		InfoMergerV3<CalgueInfo, DaypartInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithWeekday(List<CalgueInfo> baseInfos, List<WeekdayInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, WeekdayInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeWeekday());
		InfoMergerV3<CalgueInfo, WeekdayInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithCalguata(List<CalgueInfo> baseInfos, List<CalguataInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, CalguataInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalguata());
		InfoMergerV3<CalgueInfo, CalguataInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithCalate(List<CalgueInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalate());
		InfoMergerV3<CalgueInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
