package br.com.mind5.business.calendarCatalogue.info;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalgueMerger {
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
	
	
	
	public static List<CalgueInfo> mergeWithCalguata(List<CalgueInfo> baseInfos, List<CalguataInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, CalguataInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalguata());
		InfoMergerV3<CalgueInfo, CalguataInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithCalatity(List<CalgueInfo> baseInfos, List<CalatityInfo> selectedInfos) {
		InfoMergerBuilderV3<CalgueInfo, CalatityInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalatity());
		InfoMergerV3<CalgueInfo, CalatityInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
