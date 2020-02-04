package br.com.mind5.business.storeLeaveDate.info;

import java.util.List;

import br.com.mind5.business.storeLeaveDateSearch.info.StolarchInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StolateMerger {
	public static StolateInfo mergeWithStolis(StolisInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, StolisInfo> merger = new StolateMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, StolisInfo> merger = new StolateMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolateInfo mergeWithStolarch(StolarchInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, StolarchInfo> merger = new StolateMergerStolarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeWithStolarch(List<StolarchInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, StolarchInfo> merger = new StolateMergerStolarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StolateInfo mergeWithUsername(UsernameInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, UsernameInfo> merger = new StolateMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, UsernameInfo> merger = new StolateMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
	
	
	
	public static StolateInfo mergeToSelect(StolateInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeToSelect(List<StolateInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolateInfo mergeToDeleteSelect(StolateInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeToDelete(List<StolateInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StolateInfo mergeToDeleteUpdate(StolateInfo sourceOne, StolateInfo sourceTwo) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StolateInfo> mergeToUpdate(List<StolateInfo> sourceOnes, List<StolateInfo> sourceTwos) {
		InfoMerger_<StolateInfo, StolateInfo> merger = new StolateMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
