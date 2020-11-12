package br.com.mind5.business.feeOwner.info;

import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.InfoMergerBuilderV3;
import br.com.mind5.info.InfoMergerV3;

public final class FeewnerMerger {	
	public static List<FeewnerInfo> mergeWithFeedef(List<FeewnerInfo> baseInfos, List<FeedefInfo> selectedInfos) {
		InfoMergerBuilderV3<FeewnerInfo, FeedefInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FeewnerVisiMergeFeedef());
		InfoMergerV3<FeewnerInfo, FeedefInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FeewnerInfo> mergeToSelect(List<FeewnerInfo> baseInfos, List<FeewnerInfo> selectedInfos) {
		InfoMergerBuilderV3<FeewnerInfo, FeewnerInfo> builder = new InfoMergerBuilderV3<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FeewnerVisiMergeToSelect());
		InfoMergerV3<FeewnerInfo, FeewnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
