package br.com.mind5.security.userList.info;

import java.util.List;

import br.com.mind5.business.personList.info.PersolisInfo;
import br.com.mind5.info.InfoMerger;
import br.com.mind5.security.userSearch.info.UserarchInfo;

public final class UselisMerger {
	public static UselisInfo mergeWithUserarch(UserarchInfo sourceOne, UselisInfo sourceTwo) {
		InfoMerger<UselisInfo, UserarchInfo> merger = new UselisMergerUserarch();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UselisInfo> mergeWithUserarch(List<UserarchInfo> sourceOnes, List<UselisInfo> sourceTwos) {
		InfoMerger<UselisInfo, UserarchInfo> merger = new UselisMergerUserarch();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UselisInfo mergeWithPersolis(PersolisInfo sourceOne, UselisInfo sourceTwo) {
		InfoMerger<UselisInfo, PersolisInfo> merger = new UselisMergerPersolis();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UselisInfo> mergeWithPersolis(List<PersolisInfo> sourceOnes, List<UselisInfo> sourceTwos) {
		InfoMerger<UselisInfo, PersolisInfo> merger = new UselisMergerPersolis();		
		return merger.merge(sourceOnes, sourceTwos);
	}
	
	
	
	public static UselisInfo mergeToSelect(UselisInfo sourceOne, UselisInfo sourceTwo) {
		InfoMerger<UselisInfo, UselisInfo> merger = new UselisMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UselisInfo> mergeToSelect(List<UselisInfo> sourceOnes, List<UselisInfo> sourceTwos) {
		InfoMerger<UselisInfo, UselisInfo> merger = new UselisMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
