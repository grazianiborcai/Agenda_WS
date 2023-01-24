package br.com.mind5.paymentPartner.partnerPagarme.creditCardPagarme.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.payment.setupPartner.info.SetuparInfo;

public final class CrecapaMerger {
	public static List<CrecapaInfo> mergeWithSetupar(List<CrecapaInfo> baseInfos, List<SetuparInfo> selectedInfos) {
		InfoMergerBuilder<CrecapaInfo, SetuparInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecapaMergerVisiSetupar());
		InfoMerger<CrecapaInfo, SetuparInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
