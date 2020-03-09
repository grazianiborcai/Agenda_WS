package br.com.mind5.security.userSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class UserarchMerger {
	public static List<UserarchInfo> mergeToSelect(List<UserarchInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilderV3<UserarchInfo, UserarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserarchVisiMergeToSelect());
		InfoMergerV3<UserarchInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
