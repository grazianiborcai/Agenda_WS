package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoUniquifier;
import br.com.mind5.info.obsolete.InfoMergerTemplate_;
import br.com.mind5.info.obsolete.InfoMergerVisitor_;

final class SchedeekMergerStolis extends InfoMergerTemplate_<SchedeekInfo, StolisInfo> {

	@Override protected InfoMergerVisitor_<SchedeekInfo, StolisInfo> getVisitorHook() {
		return new SchedeekVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
