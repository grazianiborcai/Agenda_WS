package br.com.gda.business.company.info;

import java.util.List;

import br.com.gda.info.InfoMerger_;

final class CompMergerToDelete extends InfoMerger_<CompInfo, CompInfo, CompInfo> {
	public CompInfo merge(CompInfo sourceOne, CompInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CompVisiMergeToDelete());
	}
	
	
	
	public List<CompInfo> merge(List<CompInfo> sourceOnes, List<CompInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CompVisiMergeToDelete());
	}
}
