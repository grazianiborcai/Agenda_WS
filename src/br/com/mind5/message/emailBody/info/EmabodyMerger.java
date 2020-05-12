package br.com.mind5.message.emailBody.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class EmabodyMerger {
	public static List<EmabodyInfo> mergeToSelect(List<EmabodyInfo> baseInfos, List<EmabodyInfo> selectedInfos) {
		InfoMergerBuilderV3<EmabodyInfo, EmabodyInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmabodyVisiMergeToSelect());
		InfoMergerV3<EmabodyInfo, EmabodyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
