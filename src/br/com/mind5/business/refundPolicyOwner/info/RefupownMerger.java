package br.com.mind5.business.refundPolicyOwner.info;

import java.util.List;

import br.com.mind5.business.refundPolicyOwnerSearch.info.RefupowarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class RefupownMerger {
	public static List<RefupownInfo> mergeWithRefupowarch(List<RefupownInfo> baseInfos, List<RefupowarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, RefupowarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeRefupowarch());
		InfoMergerV3<RefupownInfo, RefupowarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefupownInfo> mergeWithRefugroup(List<RefupownInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, RefugroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeRefugroup());
		InfoMergerV3<RefupownInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefupownInfo> mergeWithUsername(List<RefupownInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeUsername());
		InfoMergerV3<RefupownInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefupownInfo> mergeToSelect(List<RefupownInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilderV3<RefupownInfo, RefupownInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefupownVisiMergeToSelect());
		InfoMergerV3<RefupownInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
