package br.com.mind5.message.sysMessage.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class SymsgMerger {
	public static List<SymsgInfo> mergeToSelect(List<SymsgInfo> baseInfos, List<SymsgInfo> selectedInfos) {
		InfoMergerBuilderV3<SymsgInfo, SymsgInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SymsgVisiMergeToSelect());
		InfoMergerV3<SymsgInfo, SymsgInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
