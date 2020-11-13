package br.com.mind5.business.scheduleReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SchederveMerger {	
	public static List<SchederveInfo> mergeToSelect(List<SchederveInfo> baseInfos, List<SchederveInfo> selectedInfos) {
		InfoMergerBuilder<SchederveInfo, SchederveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchederveVisiMergeToSelect());
		InfoMerger<SchederveInfo, SchederveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
