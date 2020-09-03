package br.com.mind5.business.calendarCatalogue.info;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDate.info.CalateInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalgueMerger {
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
