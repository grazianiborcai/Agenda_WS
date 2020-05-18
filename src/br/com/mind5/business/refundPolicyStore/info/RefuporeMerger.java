package br.com.mind5.business.refundPolicyStore.info;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class RefuporeMerger {
	public static List<RefuporeInfo> mergeWithRefuporarch(List<RefuporeInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefuporarchInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefuporarch());
		InfoMergerV3<RefuporeInfo, RefuporarchInfo> merger = builder.build();		
	
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
	
	
	
	public static List<RefuporeInfo> mergeWithRefugroup(List<RefuporeInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefugroupInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeRefugroup());
		InfoMergerV3<RefuporeInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithUsername(List<RefuporeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, UsernameInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeUsername());
		InfoMergerV3<RefuporeInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeToSelect(List<RefuporeInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilderV3<RefuporeInfo, RefuporeInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeVisiMergeToSelect());
		InfoMergerV3<RefuporeInfo, RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
