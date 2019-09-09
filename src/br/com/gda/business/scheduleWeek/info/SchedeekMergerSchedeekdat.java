package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekMergerSchedeekdat extends InfoMergerTemplate<SchedeekInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekVisiMergeSchedeekdat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
