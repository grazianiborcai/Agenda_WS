package br.com.gda.business.schedule.info;

import br.com.gda.business.materialSnapshot.info.MatsnapInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class OrderemMergerMatsnap extends InfoMergerTemplate<ScheduInfo, MatsnapInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, MatsnapInfo> getVisitorHook() {
		return new OrderemVisiMergeMatsnap();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new OrderemUniquifier();
	}
}
