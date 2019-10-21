package br.com.mind5.business.feeOwner.info;

import java.util.List;

import br.com.mind5.business.feeDefault.info.FeedefInfo;
import br.com.mind5.info.InfoMerger;

public final class FeewnerMerger {	
	public static FeewnerInfo mergeWithFeedef(FeedefInfo sourceOne, FeewnerInfo sourceTwo) {
		InfoMerger<FeewnerInfo, FeedefInfo> merger = new FeewnerMergerFeedef();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FeewnerInfo> mergeWithFeedef(List<FeedefInfo> sourceOnes, List<FeewnerInfo> sourceTwos) {
		InfoMerger<FeewnerInfo, FeedefInfo> merger = new FeewnerMergerFeedef();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static FeewnerInfo mergeToSelect(FeewnerInfo sourceOne, FeewnerInfo sourceTwo) {
		InfoMerger<FeewnerInfo, FeewnerInfo> merger = new FeewnerMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<FeewnerInfo> mergeToSelect(List<FeewnerInfo> sourceOnes, List<FeewnerInfo> sourceTwos) {
		InfoMerger<FeewnerInfo, FeewnerInfo> merger = new FeewnerMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
