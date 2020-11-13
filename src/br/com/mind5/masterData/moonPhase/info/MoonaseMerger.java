package br.com.mind5.masterData.moonPhase.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

public final class MoonaseMerger {
	public static List<MoonaseInfo> mergeWithMoonasarch(List<MoonaseInfo> baseInfos, List<MoonasarchInfo> selectedInfos) {
		InfoMergerBuilder<MoonaseInfo, MoonasarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MoonaseVisiMergeMoonasarch());
		InfoMerger<MoonaseInfo, MoonasarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
