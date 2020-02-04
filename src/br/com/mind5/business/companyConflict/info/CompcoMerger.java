package br.com.mind5.business.companyConflict.info;

import java.util.List;

import br.com.mind5.info.obsolete.InfoMerger_;

public final class CompcoMerger {	
	public static CompcoInfo mergeToSelect(CompcoInfo sourceOne, CompcoInfo sourceTwo) {
		InfoMerger_<CompcoInfo, CompcoInfo> merger = new CompcoMergerToSelect();		
		return merger.merge(sourceOne, sourceTwo);
	}
	
	
	
	public static List<CompcoInfo> mergeToSelect(List<CompcoInfo> sourceOnes, List<CompcoInfo> sourceTwos) {
		InfoMerger_<CompcoInfo, CompcoInfo> merger = new CompcoMergerToSelect();		
		return merger.merge(sourceOnes, sourceTwos);
	}
}
