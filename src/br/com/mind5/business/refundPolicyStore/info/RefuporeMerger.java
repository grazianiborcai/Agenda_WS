package br.com.mind5.business.refundPolicyStore.info;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporerchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicy.info.RefupoInfo;

public final class RefuporeMerger {
	public static List<RefuporeInfo> mergeWithRefupo(List<RefuporeInfo> baseInfos, List<RefupoInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefupoInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefupo());
		InfoMergerV3<RefuporeInfo, RefupoInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithRefupown(List<RefuporeInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefupownInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefupown());
		InfoMergerV3<RefuporeInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithRefuporerch(List<RefuporeInfo> baseInfos, List<RefuporerchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefuporerchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefuporerch());
		InfoMergerV3<RefuporeInfo, RefuporerchInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
