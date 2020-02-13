package br.com.mind5.payment.countryPartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.payment.countryPartnerSearch.info.CounparchInfo;

public final class CounparMerger {	
	public static List<CounparInfo> mergeWithPaypar(List<CounparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<CounparInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CounparVisiMergePaypar());
		InfoMergerV3<CounparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<CounparInfo> mergeWithCounparch(List<CounparInfo> baseInfos, List<CounparchInfo> selectedInfos) {
		InfoMergerBuilderV3<CounparInfo, CounparchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CounparVisiMergeCounparch());
		InfoMergerV3<CounparInfo, CounparchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
