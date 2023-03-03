package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.payOrder.info.PayordInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class OrdapaMerger {
	public static List<OrdapaInfo> mergeWithSetupar(List<OrdapaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiSetupar());
		InfoMerger<OrdapaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdapaInfo> mergeWithPayord(List<OrdapaInfo> baseInfos, List<PayordInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, PayordInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiPayord());
		InfoMerger<OrdapaInfo, PayordInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
