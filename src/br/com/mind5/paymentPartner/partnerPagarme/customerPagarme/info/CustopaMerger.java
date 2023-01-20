package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CustopaMerger {
	public static List<CustopaInfo> mergeWithSetupar(List<CustopaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<CustopaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustopaMergerVisiSetupar());
		InfoMerger<CustopaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CustopaInfo> mergeWithCus(List<CustopaInfo> baseInfos, List<CusInfo> selectedInfos) {
		InfoMergerBuilder<CustopaInfo, CusInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustopaMergerVisiCus());
		InfoMerger<CustopaInfo, CusInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
