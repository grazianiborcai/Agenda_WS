package br.com.mind5.business.refundPolicyStore.info;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;

public final class RefuporeMerger {
	public static List<RefuporeInfo> mergeWithRefupown(List<RefuporeInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefupownInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefupown());
		InfoMergerV3<RefuporeInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithRefugroup(List<RefuporeInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefugroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefugroup());
		InfoMergerV3<RefuporeInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
}