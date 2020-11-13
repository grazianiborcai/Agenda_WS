package br.com.mind5.payment.countryPartner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparMerger {	
	public static List<CounparInfo> mergeWithPaypar(List<CounparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<CounparInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CounparVisiMergePaypar());
		InfoMerger<CounparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CounparInfo> mergeWithCounparch(List<CounparInfo> baseInfos, List<CounparchInfo> selectedInfos) {
		InfoMergerBuilder<CounparInfo, CounparchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CounparVisiMergeCounparch());
		InfoMerger<CounparInfo, CounparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
