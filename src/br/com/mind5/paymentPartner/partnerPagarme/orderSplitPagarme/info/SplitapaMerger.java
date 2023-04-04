package br.com.mind5.paymentPartner.partnerPagarme.orderSplitPagarme.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class SplitapaMerger {
	public static List<SplitapaInfo> mergeWithSetupar(List<SplitapaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<SplitapaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SplitapaMergerVisiSetupar());
		InfoMerger<SplitapaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<SplitapaInfo> mergeWithPayord(List<SplitapaInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<SplitapaInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SplitapaMergerVisiPayord());
		InfoMerger<SplitapaInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
