package br.com.mind5.security.userPasswordSearch.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UpswdarchMerger {
	public static List<UpswdarchInfo> mergeWithUsername(List<UpswdarchInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdarchInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdarchVisiMergeUsername());
		InfoMergerV3<UpswdarchInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdarchInfo> mergeToSelect(List<UpswdarchInfo> baseInfos, List<UpswdarchInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdarchInfo, UpswdarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdarchVisiMergeToSelect());
		InfoMergerV3<UpswdarchInfo, UpswdarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
