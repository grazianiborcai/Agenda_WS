package br.com.mind5.message.emailBody.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class EmabodyMerger {
	public static List<EmabodyInfo> mergeToSelect(List<EmabodyInfo> baseInfos, List<EmabodyInfo> selectedInfos) {
		InfoMergerBuilder<EmabodyInfo, EmabodyInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmabodyMergerVisiToSelect());
		InfoMerger<EmabodyInfo, EmabodyInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
