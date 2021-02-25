package br.com.mind5.stats.userOrderYearStgn.info;

import java.util.List;

import br.com.mind5.business.orderList.info.OrdistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class StusorygeMerger {
	public static List<StusorygeInfo> mergeWithOrdist(List<StusorygeInfo> baseInfos, List<OrdistInfo> selectedInfos) {
		InfoMergerBuilder<StusorygeInfo, OrdistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorygeVisiMergeOrdist());
		InfoMerger<StusorygeInfo, OrdistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusorygeInfo> mergeToSelect(List<StusorygeInfo> baseInfos, List<StusorygeInfo> selectedInfos) {
		InfoMergerBuilder<StusorygeInfo, StusorygeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusorygeVisiMergeToSelect());
		InfoMerger<StusorygeInfo, StusorygeInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
