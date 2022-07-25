package br.com.mind5.discount.discountStoreSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.discountStrategy.info.DisegyInfo;

public final class DisorapMerger {
	public static List<DisorapInfo> mergeWithDisegy(List<DisorapInfo> baseInfos, List<DisegyInfo> selectedInfos) {
		InfoMergerBuilder<DisorapInfo, DisegyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisorapMergerVisiDisegy());
		InfoMerger<DisorapInfo, DisegyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<DisorapInfo> mergeToSelect(List<DisorapInfo> baseInfos, List<DisorapInfo> selectedInfos) {
		InfoMergerBuilder<DisorapInfo, DisorapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new DisorapMergerVisiToSelect());
		InfoMerger<DisorapInfo, DisorapInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
