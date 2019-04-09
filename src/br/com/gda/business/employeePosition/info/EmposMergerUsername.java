package br.com.gda.business.employeePosition.info;

import java.util.List;

import br.com.gda.info.InfoMerger;
import br.com.gda.security.username.info.UsernameInfo;

final class EmposMergerUsername extends InfoMerger<EmposInfo, UsernameInfo, EmposInfo> {
	public EmposInfo merge(UsernameInfo sourceOne, EmposInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new EmposVisiMergeUsername());
	}
	
	
	
	public List<EmposInfo> merge(List<UsernameInfo> sourceOnes, List<EmposInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new EmposVisiMergeUsername());
	}
}
