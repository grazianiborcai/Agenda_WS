package br.com.mind5.message.emailWelcome.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmacomeMerger {
	public static List<EmacomeInfo> mergeWithOwnelis(List<EmacomeInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilderV3<EmacomeInfo, OwnelisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmacomeVisiMergeOwnelis());
		InfoMergerV3<EmacomeInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
