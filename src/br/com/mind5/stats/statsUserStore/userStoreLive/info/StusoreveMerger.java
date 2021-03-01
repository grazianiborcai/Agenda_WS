package br.com.mind5.stats.statsUserStore.userStoreLive.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.currency.info.CurrencyInfo;

public final class StusoreveMerger {
	public static List<StusoreveInfo> mergeWithCurrency(List<StusoreveInfo> baseInfos, List<CurrencyInfo> selectedInfos) {
		InfoMergerBuilder<StusoreveInfo, CurrencyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoreveVisiMergeCurrency());
		InfoMerger<StusoreveInfo, CurrencyInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StusoreveInfo> mergeToSelect(List<StusoreveInfo> baseInfos, List<StusoreveInfo> selectedInfos) {
		InfoMergerBuilder<StusoreveInfo, StusoreveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StusoreveVisiMergeToSelect());
		InfoMerger<StusoreveInfo, StusoreveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
