package br.com.mind5.business.addressSearch.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class AddarchMerger {	
	public static AddarchInfo mergeToSelect(AddarchInfo sourceOne, AddarchInfo sourceTwo) {
		InfoMerger_<AddarchInfo, AddarchInfo> merger = new AddarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddarchInfo> mergeToSelect(List<AddarchInfo> sourceOnes, List<AddarchInfo> sourceTwos) {
		InfoMerger_<AddarchInfo, AddarchInfo> merger = new AddarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
