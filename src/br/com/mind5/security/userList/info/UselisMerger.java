package br.com.mind5.security.userList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.file.fileImageList.info.FimistInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UselisMerger {
	public static List<UselisInfo> mergeWithFimist(List<UselisInfo> baseInfos, List<FimistInfo> selectedInfos) {
		InfoMergerBuilder<UselisInfo, FimistInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisMergerVisiFimist());
		InfoMerger<UselisInfo, FimistInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UselisInfo> mergeWithUserarch(List<UselisInfo> baseInfos, List<UserarchInfo> selectedInfos) {
		InfoMergerBuilder<UselisInfo, UserarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisMergerVisiUserarch());
		InfoMerger<UselisInfo, UserarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UselisInfo> mergeWithPersolis(List<UselisInfo> baseInfos, List<PersolisInfo> selectedInfos) {
		InfoMergerBuilder<UselisInfo, PersolisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisMergerVisiPersolis());
		InfoMerger<UselisInfo, PersolisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<UselisInfo> mergeToSelect(List<UselisInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<UselisInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new UselisMergerVisiToSelect());
		InfoMerger<UselisInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
