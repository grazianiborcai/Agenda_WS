package br.com.gda.business.schedule.info;

import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class ScheduMergerToSelect extends InfoMergerTemplate<ScheduInfo, ScheduInfo> {

	@Override protected InfoMergerVisitor<ScheduInfo, ScheduInfo> getVisitorHook() {
		return new ScheduVisiMergeToSelect();
	}
	
	
	
	@Override protected InfoUniquifier<ScheduInfo> getUniquifierHook() {
		return new ScheduUniquifier();
	}
}
