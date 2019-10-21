package br.com.mind5.business.scheduleWeek.info;

import br.com.mind5.business.storeList.info.StolisInfo;
import br.com.mind5.info.InfoMergerTemplate;
import br.com.mind5.info.InfoMergerVisitor;
import br.com.mind5.info.InfoUniquifier;

final class SchedeekMergerStolis extends InfoMergerTemplate<SchedeekInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, StolisInfo> getVisitorHook() {
		return new SchedeekVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
