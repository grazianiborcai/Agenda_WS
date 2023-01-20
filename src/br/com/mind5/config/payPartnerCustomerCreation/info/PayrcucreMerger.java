package br.com.mind5.config.payPartnerCustomerCreation.info;

import java.util.List;

import br.com.mind5.config.payPartnerConfig.info.PayrconfInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;

public final class PayrcucreMerger {	
	public static List<PayrcucreInfo> mergeWithPayrconf(List<PayrcucreInfo> baseInfos, List<PayrconfInfo> selectedInfos) {
		InfoMergerBuilder<PayrcucreInfo, PayrconfInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new PayrcucreMergerVisiPayrconf());
		InfoMerger<PayrcucreInfo, PayrconfInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
