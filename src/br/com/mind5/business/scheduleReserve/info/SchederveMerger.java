package br.com.mind5.business.scheduleReserve.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SchederveMerger {	
	public static List<SchederveInfo> mergeToSelect(List<SchederveInfo> baseInfos, List<SchederveInfo> selectedInfos) {
		InfoMergerBuilderV3<SchederveInfo, SchederveInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchederveVisiMergeToSelect());
		InfoMergerV3<SchederveInfo, SchederveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
