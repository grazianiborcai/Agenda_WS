package br.com.mind5.message.sysMessage.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class SymsgMerger {
	public static List<SymsgInfo> mergeToSelect(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilder<SymsgInfo, SymsgInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SymsgVisiMergeToSelect());
		InfoMerger<SymsgInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
