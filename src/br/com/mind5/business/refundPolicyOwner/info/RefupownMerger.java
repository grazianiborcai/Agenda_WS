package br.com.mind5.business.refundPolicyOwner.info;

import java.util.List;

import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class RefupownMerger {
	public static List<RefupownInfo> mergeWithRefugroup(List<RefupownInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilder<RefupownInfo, RefugroupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownMergerVisiRefugroup());
		InfoMerger<RefupownInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefupownInfo> mergeWithUsername(List<RefupownInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<RefupownInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownMergerVisiUsername());
		InfoMerger<RefupownInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefupownInfo> mergeToSelect(List<RefupownInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilder<RefupownInfo, RefupownInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownMergerVisiToSelect());
		InfoMerger<RefupownInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
