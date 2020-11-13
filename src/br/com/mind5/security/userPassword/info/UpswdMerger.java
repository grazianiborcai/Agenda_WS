package br.com.mind5.security.userPassword.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class UpswdMerger {
	public static List<UpswdInfo> mergeWithUsername(List<UpswdInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<UpswdInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeUsername());
		InfoMerger<UpswdInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdInfo> mergeWithUselis(List<UpswdInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<UpswdInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeUselis());
		InfoMerger<UpswdInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UpswdInfo> mergeToAuth(List<UpswdInfo> baseInfos, List<UpswdInfo> selectedInfos) {
		InfoMergerBuilder<UpswdInfo, UpswdInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UpswdVisiMergeToAuth());
		InfoMerger<UpswdInfo, UpswdInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
