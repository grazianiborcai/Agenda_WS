package br.com.mind5.paymentPartner.partnerPagarme.orderPagarme.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.creditCard.info.CrecardInfo;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.payOrderItem.info.PayordemInfo;
import br.com.mind5.payment.payOrderList.info.PayordistInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class OrdapaMerger {
	public static List<OrdapaInfo> mergeWithCrecard(List<OrdapaInfo> baseInfos, List<CrecardInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, CrecardInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiCrecard());
		InfoMerger<OrdapaInfo, CrecardInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdapaInfo> mergeWithCuspar(List<OrdapaInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiCuspar());
		InfoMerger<OrdapaInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdapaInfo> mergeWithPayordist(List<OrdapaInfo> baseInfos, List<PayordistInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, PayordistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiPayordist());
		InfoMerger<OrdapaInfo, PayordistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdapaInfo> mergeWithSetupar(List<OrdapaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiSetupar());
		InfoMerger<OrdapaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<OrdapaInfo> mergeWithPayordem(List<OrdapaInfo> baseInfos, List<PayordemInfo> selectedInfos) {
		InfoMergerBuilder<OrdapaInfo, PayordemInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new OrdapaMergerVisiPayordem());
		InfoMerger<OrdapaInfo, PayordemInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
