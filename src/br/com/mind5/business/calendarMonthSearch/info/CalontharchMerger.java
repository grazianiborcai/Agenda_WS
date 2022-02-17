package br.com.mind5.business.calendarMonthSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class CalontharchMerger {
	public static List<CalontharchInfo> mergeToSelect(List<CalontharchInfo> baseInfos, List<CalontharchInfo> selectedInfos) {
		InfoMergerBuilder<CalontharchInfo, CalontharchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CalontharchVisiMergeToSelect());
		InfoMerger<CalontharchInfo, CalontharchInfo> merger = builder.build();
	
		return merger.merge();
	}
}
