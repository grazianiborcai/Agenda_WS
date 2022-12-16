package br.com.mind5.config.payPartnerStoreCreation.info;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PayrsocreMerger {	
	public static List<PayrsocreInfo> mergeWithPayrconf(List<PayrsocreInfo> baseInfos, List<PayrconfInfo> selectedInfos) {
		InfoMergerBuilder<PayrsocreInfo, PayrconfInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayrsocreMergerVisiPayrconf());
		InfoMerger<PayrsocreInfo, PayrconfInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
