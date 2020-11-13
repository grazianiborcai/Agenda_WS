package br.com.mind5.authorization.scheduleAuthorization.info;

import java.util.List;

import br.com.mind5.business.storeSearch.info.SotarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.username.info.UsernameInfo;

public final class SchedauthMerger {
	public static List<SchedauthInfo> mergeWithSotarch(List<SchedauthInfo> baseInfos, List<SotarchInfo> selectedInfos) {
		InfoMergerBuilder<SchedauthInfo, SotarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedauthVisiMergeSotarch());
		InfoMerger<SchedauthInfo, SotarchInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedauthInfo> mergeWithUsername(List<SchedauthInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<SchedauthInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedauthVisiMergeUsername());
		InfoMerger<SchedauthInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}	
	
	
	
	public static List<SchedauthInfo> mergeToSelect(List<SchedauthInfo> baseInfos, List<SchedauthInfo> selectedInfos) {
		InfoMergerBuilder<SchedauthInfo, SchedauthInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new SchedauthVisiMergeToSelect());
		InfoMerger<SchedauthInfo, SchedauthInfo> merger = builder.build();		
	
		return merger.merge();
	}	
}
