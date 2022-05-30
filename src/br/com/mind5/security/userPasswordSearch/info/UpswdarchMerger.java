package br.com.mind5.security.userPasswordSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UpswdarchMerger {
	public static List<UpswdarchInfo> mergeWithUsername(List<UpswdarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<UpswdarchInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdarchMergerVisiUsername());
		InfoMerger<UpswdarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdarchInfo> mergeToSelect(List<UpswdarchInfo> baseInfos, List<UpswdarchInfo> selectedInfos) {
		InfoMergerBuilder<UpswdarchInfo, UpswdarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdarchMergerVisiToSelect());
		InfoMerger<UpswdarchInfo, UpswdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
