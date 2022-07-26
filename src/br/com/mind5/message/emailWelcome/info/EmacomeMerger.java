package br.com.mind5.message.emailWelcome.info;

import java.util.List;

import br.com.mind5.business.ownerList.info.OwnelisInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userList.info.UselisInfo;

public final class EmacomeMerger {
	public static List<EmacomeInfo> mergeWithOwnelis(List<EmacomeInfo> baseInfos, List<OwnelisInfo> selectedInfos) {
		InfoMergerBuilder<EmacomeInfo, OwnelisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmacomeMergerVisiOwnelis());
		InfoMerger<EmacomeInfo, OwnelisInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<EmacomeInfo> mergeWithUselis(List<EmacomeInfo> baseInfos, List<UselisInfo> selectedInfos) {
		InfoMergerBuilder<EmacomeInfo, UselisInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new EmacomeMergerVisiUselis());
		InfoMerger<EmacomeInfo, UselisInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
