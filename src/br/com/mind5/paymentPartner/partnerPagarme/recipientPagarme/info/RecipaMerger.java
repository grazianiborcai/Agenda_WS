package br.com.mind5.paymentPartner.partnerPagarme.recipientPagarme.info;

import java.util.List;

import br.com.mind5.business.bankAccount.info.BankaccInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class RecipaMerger {
	public static List<RecipaInfo> mergeWithBankacc(List<RecipaInfo> baseInfos, List<BankaccInfo> selectedInfos) {
		InfoMergerBuilder<RecipaInfo, BankaccInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RecipaMergerVisiBankacc());
		InfoMerger<RecipaInfo, BankaccInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RecipaInfo> mergeWithSetupar(List<RecipaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<RecipaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RecipaMergerVisiSetupar());
		InfoMerger<RecipaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RecipaInfo> mergeWithStolis(List<RecipaInfo> baseInfos, List<StolisInfo> selectedInfos) {
		InfoMergerBuilder<RecipaInfo, StolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RecipaMergerVisiStolis());
		InfoMerger<RecipaInfo, StolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
