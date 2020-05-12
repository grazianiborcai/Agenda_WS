package br.com.mind5.security.userPassword.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UpswdMerger {
	public static List<UpswdInfo> mergeWithUsername(List<UpswdInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeUsername());
		InfoMergerV3<UpswdInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdInfo> mergeWithUselis(List<UpswdInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdInfo, UselisInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeUselis());
		InfoMergerV3<UpswdInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdInfo> mergeToAuth(List<UpswdInfo> baseInfos, List<UpswdInfo> selectedInfos) {
		InfoMergerBuilderV3<UpswdInfo, UpswdInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeToAuth());
		InfoMergerV3<UpswdInfo, UpswdInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
