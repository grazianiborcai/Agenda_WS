package br.com.mind5.stats.statsOwnerSale.ownerSale.info;

import java.util.List;

import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.stats.statsOwnerSale.ownerSaleLive.info.SowaliveInfo;

public final class SowalMerger {
	public static List<SowalInfo> mergeWithSowalive(List<SowalInfo> baseInfos, List<SowaliveInfo> selectedInfos) {
		InfoMergerBuilder<SowalInfo, SowaliveInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SowalVisiMergeSowalive());
		InfoMerger<SowalInfo, SowaliveInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
