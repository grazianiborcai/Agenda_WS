package br.com.mind5.masterData.moonPhase.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.moonPhaseSearch.info.MoonasarchInfo;

public final class MoonaseMerger {
	public static List<MoonaseInfo> mergeWithMoonasarch(List<MoonaseInfo> baseInfos, List<MoonasarchInfo> selectedInfos) {
		InfoMergerBuilderV3<MoonaseInfo, MoonasarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new MoonaseVisiMergeMoonasarch());
		InfoMergerV3<MoonaseInfo, MoonasarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
