package br.com.mind5.business.storeAccount.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.masterData.paymentPartnerDefault.info.PayparultInfo;

public final class StoracMerger {	
	public static List<StoracInfo> mergeWithPayparult(List<StoracInfo> baseInfos, List<PayparultInfo> selectedInfos) {
		InfoMergerBuilder<StoracInfo, PayparultInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoracMergerVisiPayparult());
		InfoMerger<StoracInfo, PayparultInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
