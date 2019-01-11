package br.com.gda.business.owner.info;

import java.util.List;

import br.com.gda.business.company.info.CompInfo;
import br.com.gda.info.InfoMerger;

final class OwnerMergerComp extends InfoMerger<OwnerInfo, CompInfo, OwnerInfo> {
	public OwnerInfo merge(CompInfo sourceOne, OwnerInfo sourceTwo) {
		return super.write(sourceOne, sourceTwo, new OwnerVisitorComp());
	}
	
	
	
	public List<OwnerInfo> merge(List<CompInfo> sourceOnes, List<OwnerInfo> sourceTwos) {		
		return super.write(sourceOnes, sourceTwos, new OwnerVisitorComp());
	}
}
