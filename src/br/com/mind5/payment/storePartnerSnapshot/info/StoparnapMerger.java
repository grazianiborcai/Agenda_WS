package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class StoparnapMerger {
	public static List<StoparnapInfo> mergeWithPaypar(List<StoparnapInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparnapInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparnapVisiMergePaypar());
		InfoMergerV3<StoparnapInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoparnapInfo> mergeToSelect(List<StoparnapInfo> baseInfos, List<StoparnapInfo> selectedInfos) {
		InfoMergerBuilderV3<StoparnapInfo, StoparnapInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparnapVisiMergeToSelect());
		InfoMergerV3<StoparnapInfo, StoparnapInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
