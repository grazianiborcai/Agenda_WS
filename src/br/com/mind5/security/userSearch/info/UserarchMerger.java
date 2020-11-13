package br.com.mind5.security.userSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class UserarchMerger {
	public static List<UserarchInfo> mergeToSelect(List<UserarchInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilder<UserarchInfo, UserarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UserarchVisiMergeToSelect());
		InfoMerger<UserarchInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
