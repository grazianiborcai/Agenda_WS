package br.com.mind5.payment.setupPartner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.paymentPartner.info.PayparInfo;

public final class SetuparMerger {	
	public static List<SetuparInfo> mergeWithPaypar(List<SetuparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilder<SetuparInfo, PayparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SetuparMergerVisiPaypar());
		InfoMerger<SetuparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
