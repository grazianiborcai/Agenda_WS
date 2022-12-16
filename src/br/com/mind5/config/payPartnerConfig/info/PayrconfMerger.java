package br.com.mind5.config.payPartnerConfig.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PayrconfMerger {	
	public static List<PayrconfInfo> mergeToSelect(List<PayrconfInfo> baseInfos, List<PayrconfInfo> selectedInfos) {
		InfoMergerBuilder<PayrconfInfo, PayrconfInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayrconfMergerVisiToSelect());
		InfoMerger<PayrconfInfo, PayrconfInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
