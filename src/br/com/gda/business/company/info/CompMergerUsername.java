package br.com.gda.business.company.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class CompMergerUsername extends InfoMerger<CompInfo, UsernameInfo, CompInfo> {
	public CompInfo merge(UsernameInfo sourceOne, CompInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new CompVisiMergeUsername());
	}
	
	
	
	public List<CompInfo> merge(List<UsernameInfo> sourceOnes, List<CompInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new CompVisiMergeUsername());
	}
}
