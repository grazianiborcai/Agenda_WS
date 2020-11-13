package br.com.mind5.business.feeOwner.info;

import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.InfoMergerBuilder;
import br.com.mind5.info.InfoMerger;

public final class FeewnerMerger {	
	public static List<FeewnerInfo> mergeWithFeedef(List<FeewnerInfo> baseInfos, List<FeedefInfo> selectedInfos) {
		InfoMergerBuilder<FeewnerInfo, FeedefInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FeewnerVisiMergeFeedef());
		InfoMerger<FeewnerInfo, FeedefInfo> merger = builder.build();		
	
		return merger.merge();
	}
	
	
	
	public static List<FeewnerInfo> mergeToSelect(List<FeewnerInfo> baseInfos, List<FeewnerInfo> selectedInfos) {
		InfoMergerBuilder<FeewnerInfo, FeewnerInfo> builder = new InfoMergerBuilder<>();
		
		builder.addBaseInfos(baseInfos);
		builder.addSelectedInfos(selectedInfos);
		builder.addVisitor(new FeewnerVisiMergeToSelect());
		InfoMerger<FeewnerInfo, FeewnerInfo> merger = builder.build();		
	
		return merger.merge();
	}
}
