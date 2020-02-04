package br.com.mind5.security.userSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class UserarchMerger {
	public static UserarchInfo mergeToSelect(UserarchInfo sourceOne, UserarchInfo sourceTwo) {
		InfoMerger_<UserarchInfo, UserarchInfo> merger = new UserarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<UserarchInfo> mergeToSelect(List<UserarchInfo> sourceOnes, List<UserarchInfo> sourceTwos) {
		InfoMerger_<UserarchInfo, UserarchInfo> merger = new UserarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}	
}
