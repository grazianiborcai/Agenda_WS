package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.scheduleWeekData.info.SchedeekdatInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekMergerSchedeekdat extends InfoMergerTemplate_<SchedeekInfo, SchedeekdatInfo> {

	@Override protected InfoMergerVisitor_<SchedeekInfo, SchedeekdatInfo> getVisitorHook() {
		return new SchedeekVisiMergeSchedeekdat();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
