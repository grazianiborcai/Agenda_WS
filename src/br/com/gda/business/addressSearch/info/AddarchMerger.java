package br.com.gda.business.addressSearch.info;

import java.util.List;

import br.com.gda.info.InfoMerger;

public final class AddarchMerger {	
	public static AddarchInfo mergeToSelect(AddarchInfo sourceOne, AddarchInfo sourceTwo) {
		InfoMerger<AddarchInfo, AddarchInfo> merger = new AddarchMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<AddarchInfo> mergeToSelect(List<AddarchInfo> sourceOnes, List<AddarchInfo> sourceTwos) {
		InfoMerger<AddarchInfo, AddarchInfo> merger = new AddarchMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
