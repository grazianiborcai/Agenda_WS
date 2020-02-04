package br.com.mind5.business.storeWorkTime.info;

import java.util.List;

import br.com.mind5.business.masterData.info.WeekdayInfo;
import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.business.storeWorkTimeSearch.info.StowotarchInfo;
import br.com.mind5.info.obsolete.InfoMerger_;
import br.com.mind5.security.username.info.UsernameInfo;

public final class StowotmMerger {
	public static StowotmInfo mergeWithStowotarch(StowotarchInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, StowotarchInfo> merger = new StowotmMergerStowotarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeWithStowotarch(List<StowotarchInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, StowotarchInfo> merger = new StowotmMergerStowotarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeWithWeekday(WeekdayInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, WeekdayInfo> merger = new StowotmMergerWeekday();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeWithWeekday(List<WeekdayInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, WeekdayInfo> merger = new StowotmMergerWeekday();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeWithStolis(StolisInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, StolisInfo> merger = new StowotmMergerStolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeWithStolis(List<StolisInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, StolisInfo> merger = new StowotmMergerStolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeWithUsername(UsernameInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, UsernameInfo> merger = new StowotmMergerUsername();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeWithUsername(List<UsernameInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, UsernameInfo> merger = new StowotmMergerUsername();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeToSelect(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeToSelect(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeToDelete(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToDelete();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeToDelete(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToDelete();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static StowotmInfo mergeToUpdate(StowotmInfo sourceOne, StowotmInfo sourceTwo) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToUpdate();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<StowotmInfo> mergeToUpdate(List<StowotmInfo> sourceOnes, List<StowotmInfo> sourceTwos) {
		InfoMerger_<StowotmInfo, StowotmInfo> merger = new StowotmMergerToUpdate();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
