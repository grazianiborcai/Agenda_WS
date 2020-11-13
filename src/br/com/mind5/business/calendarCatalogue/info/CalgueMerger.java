package br.com.mind5.business.calendarCatalogue.info;

import java.util.List;

import br.com.mind5.business.calendarCatalogueData.info.CalguataInfo;
import br.com.mind5.business.calendarDateAvailability.info.CalatityInfo;
import br.com.mind5.business.materialList.info.MatlisInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CalgueMerger {
	public static List<CalgueInfo> mergeWithStolis(List<CalgueInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<CalgueInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeStolis());
		InfoMerger<CalgueInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithMatlis(List<CalgueInfo> baseInfos, List<MatlisInfo> selectedInfos) {
		InfoMergerBuilder<CalgueInfo, MatlisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeMatlis());
		InfoMerger<CalgueInfo, MatlisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithCalguata(List<CalgueInfo> baseInfos, List<CalguataInfo> selectedInfos) {
		InfoMergerBuilder<CalgueInfo, CalguataInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalguata());
		InfoMerger<CalgueInfo, CalguataInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CalgueInfo> mergeWithCalatity(List<CalgueInfo> baseInfos, List<CalatityInfo> selectedInfos) {
		InfoMergerBuilder<CalgueInfo, CalatityInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalgueVisiMergeCalatity());
		InfoMerger<CalgueInfo, CalatityInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
