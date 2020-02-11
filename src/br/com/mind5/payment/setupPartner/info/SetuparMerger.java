package br.com.mind5.payment.setupPartner.info;

import java.util.List;

import br.com.mind5.business.masterData.info.PayparInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SetuparMerger {	
	public static List<SetuparInfo> mergeWithPaypar(List<SetuparInfo> baseInfos, List<PayparInfo> selectedInfos) {
		InfoMergerBuilderV3<SetuparInfo, PayparInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SetuparVisiMergePaypar());
		InfoMergerV3<SetuparInfo, PayparInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
