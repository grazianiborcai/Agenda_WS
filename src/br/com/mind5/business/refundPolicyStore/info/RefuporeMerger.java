package br.com.mind5.business.refundPolicyStore.info;

import java.util.List;

import br.com.mind5.business.refundPolicyOwner.info.RefupownInfo;
import br.com.mind5.business.refundPolicyStoreSearch.info.RefuporarchInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.masterData.refundPolicyGroup.info.RefugroupInfo;
import br.com.mind5.security.username.info.UsernameInfo;

public final class RefuporeMerger {
	public static List<RefuporeInfo> mergeWithRefuporarch(List<RefuporeInfo> baseInfos, List<RefuporarchInfo> selectedInfos) {
		InfoMergerBuilder<RefuporeInfo, RefuporarchInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeMergerVisiRefuporarch());
		InfoMerger<RefuporeInfo, RefuporarchInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithRefupown(List<RefuporeInfo> baseInfos, List<RefupownInfo> selectedInfos) {
		InfoMergerBuilder<RefuporeInfo, RefupownInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeMergerVisiRefupown());
		InfoMerger<RefuporeInfo, RefupownInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithRefugroup(List<RefuporeInfo> baseInfos, List<RefugroupInfo> selectedInfos) {
		InfoMergerBuilder<RefuporeInfo, RefugroupInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeMergerVisiRefugroup());
		InfoMerger<RefuporeInfo, RefugroupInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeWithUsername(List<RefuporeInfo> baseInfos, List<UsernameInfo> selectedInfos) {
		InfoMergerBuilder<RefuporeInfo, UsernameInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeMergerVisiUsername());
		InfoMerger<RefuporeInfo, UsernameInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<RefuporeInfo> mergeToSelect(List<RefuporeInfo> baseInfos, List<RefuporeInfo> selectedInfos) {
		InfoMergerBuilder<RefuporeInfo, RefuporeInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new RefuporeMergerVisiToSelect());
		InfoMerger<RefuporeInfo, RefuporeInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
