package br.com.gda.business.scheduleWeek.info;

import br.com.gda.business.storeList.info.StolisInfo;
import br.com.gda.info.InfoMergerTemplate;
import br.com.gda.info.InfoMergerVisitor;
import br.com.gda.info.InfoUniquifier;

final class SchedeekMergerStolis extends InfoMergerTemplate<SchedeekInfo, StolisInfo> {

	@Override protected InfoMergerVisitor<SchedeekInfo, StolisInfo> getVisitorHook() {
		return new SchedeekVisiMergeStolis();
	}
	
	
	
	@Override protected InfoUniquifier<SchedeekInfo> getUniquifierHook() {
		return new SchedeekUniquifier();
	}
}
