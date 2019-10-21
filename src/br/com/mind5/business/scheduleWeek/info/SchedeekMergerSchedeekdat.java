package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekMergerSchedeekdat extends InfoMergerTemplate<SchedeekInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekVisiMergeSchedeekdat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
