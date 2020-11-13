package br.com.mind5.payment.storePartnerSnapshot.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class StoparnapMerger {
	public static List<StoparnapInfo> mergeWithPaypar(List<StoparnapInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<StoparnapInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparnapVisiMergePaypar());
		InfoMerger<StoparnapInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<StoparnapInfo> mergeToSelect(List<StoparnapInfo> baseInfos, List<StoparnapInfo> selectedInfos) {
		InfoMergerBuilder<StoparnapInfo, StoparnapInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new StoparnapVisiMergeToSelect());
		InfoMerger<StoparnapInfo, StoparnapInfo> merger = builder.build();		
	
		return merger.merge();
	}			
}
