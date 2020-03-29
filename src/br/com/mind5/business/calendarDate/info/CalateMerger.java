package br.com.mind5.business.calendarDate.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CalateMerger {
	public static List<CalateInfo> mergeToSelect(List<CalateInfo> baseInfos, List<CalateInfo> selectedInfos) {
		InfoMergerBuilderV3<CalateInfo, CalateInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalateVisiMergeToSelect());
		InfoMergerV3<CalateInfo, CalateInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
