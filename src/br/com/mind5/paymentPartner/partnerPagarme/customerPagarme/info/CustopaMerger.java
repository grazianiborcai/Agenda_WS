package br.com.mind5.paymentPartner.partnerPagarme.customerPagarme.info;

import java.util.List;

import br.com.mind5.business.customer.info.CusInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.customerPartner.info.CusparInfo;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;
import br.com.mind5.security.user.info.UserInfo;

public final class CustopaMerger {
	public static List<CustopaInfo> mergeWithCuspar(List<CustopaInfo> baseInfos, List<CusparInfo> selectedInfos) {
		InfoMergerBuilder<CustopaInfo, CusparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustopaMergerVisiCuspar());
		InfoMerger<CustopaInfo, CusparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
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
	
	
	
	public static List<CustopaInfo> mergeWithUser(List<CustopaInfo> baseInfos, List<UserInfo> selectedInfos) {
		InfoMergerBuilder<CustopaInfo, UserInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CustopaMergerVisiUser());
		InfoMerger<CustopaInfo, UserInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
