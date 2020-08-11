package br.com.mind5.security.userPasswordSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class UpswdarchMerger {
	public static List<UpswdarchInfo> mergeToSelect(List<UpswdarchInfo> baseInfos, List<UpswdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdarchInfo, UpswdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdarchVisiMergeToSelect());
		InfoMergerV3<UpswdarchInfo, UpswdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
