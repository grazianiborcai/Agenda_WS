package br.com.mind5.payment.creditCardSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class CrecarchMerger {
	public static List<CrecarchInfo> mergeToSelect(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {
		InfoMergerBuilder<CrecarchInfo, CrecarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecarchMergerVisiToSelect());
		InfoMerger<CrecarchInfo, CrecarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
