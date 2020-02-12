package br.com.mind5.payment.creditCardSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class CrecarchMerger {
	public static List<CrecarchInfo> mergeToSelect(List<CrecarchInfo> baseInfos, List<CrecarchInfo> selectedInfos) {
		InfoMergerBuilderV3<CrecarchInfo, CrecarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new CrecarchVisiMergeToSelect());
		InfoMergerV3<CrecarchInfo, CrecarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
